package com.ipartek.formacion.controller.backoffice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.Alerta;
import com.ipartek.formacion.modelo.dao.impl.CategoriaDAOImpl;
import com.ipartek.formacion.modelo.pojo.Categoria;

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
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LOG.trace("envian datos desde un formulario");
	}

}
