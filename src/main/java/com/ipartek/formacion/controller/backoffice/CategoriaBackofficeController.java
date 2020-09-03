package com.ipartek.formacion.controller.backoffice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.Alerta;
import com.ipartek.formacion.modelo.dao.impl.CategoriaDAOImpl;
import com.ipartek.formacion.modelo.pojo.Categoria;
import com.ipartek.formacion.modelo.pojo.Producto;

/**
 * Servlet implementation class CategoriaBackofficeController
 */
@WebServlet("/views/backoffice/categoria")
public class CategoriaBackofficeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(CategoriaBackofficeController.class);
	private static final CategoriaDAOImpl dao = CategoriaDAOImpl.getInstance();
	private static final String VIEW_LISTA = "categoria/index.jsp";
	private static final String VIEW_FORM = "categoria/formulario.jsp";
	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private static Validator validator = factory.getValidator();
       
	/**
	 * Se encarga de listar, eliminar o mostrar una categoria en el fomrulario
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LOG.trace("Listado categorias");
		String idParam = request.getParameter("id");
		String accionParam = request.getParameter("accion");
		
		String forward = VIEW_LISTA;
		try {
			
			// LISTAR
			if ( idParam == null ) {			
				
				ArrayList<Categoria> listado = dao.getAll();			
				request.setAttribute("categorias", listado );
				
			// ELIMINAR	
			}else if ( accionParam != null ) { 
			
				int id = Integer.parseInt(idParam);
				try {
					dao.delete(id);
					request.setAttribute("alerta", new Alerta("success", "Categoria Eliminada con exito"));
				}catch (Exception e) {
					request.setAttribute("alerta", new Alerta("warning", "Categoria tiene productos asociados y no se puede eliminar"));
				}	
				// despues de eliminar conseguimos todas las categorias y vamos al listado
				request.setAttribute("categorias", dao.getAll() );
				
				
			// MOSTRA EN FORMULARIO	
			}else{        
				
				Categoria categoria = new Categoria();
				int id = Integer.parseInt(idParam);
				
				if( id > 0 ) {
					categoria = dao.getById(id);
				}
				
				request.setAttribute("categoria", categoria);
				forward = VIEW_FORM;
			}
			
		}catch (Exception e) {			
			LOG.error(e);
			
		}finally {	
			// como el controlador escucha en la url "/views/backoffice/categoria"
			// para hacer el forward pierde la utima parte de la url "categoria" y debemos añadir la caroeta donde esta la index de las categorias
			// /views/backoffice/ + categoria/index.jsp			
			request.getRequestDispatcher(forward).forward(request, response);
		}	
		
	}

	/**
	 * recoge los datos del formulario y los guarda en la base datos.
	 * Nos sirve tanto para crear una categoria como para modificarla
	 * 
	 * 1) recoger parametro del formulario
	 * 2) validar que sean correctos
	 * 3) guardar en la bbdd
	 * 
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//TODOS a comprobar
		// 1 todo bien
		// 2 los datos introduciodos en el formulario no sean correctos
		// 3 nombre categoria duplicado
		LOG.trace("envian datos desde un formulario");
		
		String idParam = request.getParameter("id");
		String nombreParam = request.getParameter("nombre");
		Alerta alerta = new Alerta();
		Categoria cat = new Categoria();
		
		try {
			
			int id = Integer.parseInt(idParam);
			
			// Mapeado los datos del formulario al POJO
			cat.setId(id);
			cat.setNombre(nombreParam);
			
			// validar datos envaidos antes de insertar
			Set<ConstraintViolation<Categoria>> violations = validator.validate(cat);
			if ( !violations.isEmpty() ) {
				
				alerta = new Alerta("warning", "Los datos introducidos no son correctos");
				
			// no hay errores de validacion, guardar en bbdd	
			}else {
				
				try {
					if ( id > 0) {
						dao.update(cat);
					}else {
						dao.insert(cat);
					}
					alerta = new Alerta("success", "Categoria guardada con exito");
					
				}catch (Exception e) {
					alerta = new Alerta("warning", "El nombre de la Categoria ya existe, por favor elige otro.");
				}	
			}
			
			
		}catch (Exception e) {
			LOG.error(e);
			alerta = new Alerta("danger", "Lo sentimos pero tenemos un fallo");
			
		}finally {
			request.setAttribute("categoria", cat);
			request.setAttribute("alerta", alerta);
			request.getRequestDispatcher(VIEW_FORM).forward(request, response);
		}
		
		
		
	}

}
