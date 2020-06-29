package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.dao.impl.CategoriaDAOImpl;
import com.ipartek.formacion.modelo.pojo.Categoria;

/**
 * Servlet implementation class CategoriaController
 */
@WebServlet("/categoria")
public class CategoriaController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(CategoriaController.class);
	
	private static final CategoriaDAOImpl categoriaDao = CategoriaDAOImpl.getInstance();
	
	private static final String VIEW_TABLA = "views/categorias/index.jsp";
	private static final String VIEW_FORMULARIO = "views/categorias/formulario.jsp";
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @paramter id id Categoria
	 * @paremter operacion para saber si queremos eliminar
	 * IR FORMULARIO     => Si recibimos como parametro el id de la categoria, iremos al formulario para poder guardarla
	 * ELIMNAR CATEGORIA => Si recibimos como parametros el id de la categoria y operacion == 2, Eliminamos la Categoria y vamos a la tabla
	 * MOSTRAR TABLA     => Si id categoria es null mostramos la tabla con todas
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String view = VIEW_TABLA;
		Alerta alerta = new Alerta();
		String paramId = request.getParameter("id");
		String operacionEliminar = request.getParameter("operacion");
		
		Categoria categoria = new Categoria();
		
		try {
		
			if ( paramId != null ) {
				
				int id = Integer.parseInt(paramId);
				
				if ( operacionEliminar != null ) {   /// ELIMINAR
					
					categoriaDao.delete(id);
					alerta = new Alerta("success", "Registro eliminado");
					
					
				}else {                            // IR AL FORMULARIO
					
					if ( id > 0 ) {
						categoria = categoriaDao.getById(id);
					}				
					view = VIEW_FORMULARIO;
				}	
				
			
			}	
			
		}catch (Exception e) {
			LOG.error(e);
			alerta = new Alerta("danger", "No se puede eliminar la Categoria si tiene productos asociados");
			
		}finally {
			
			request.setAttribute("alerta", alerta);
			request.setAttribute("categoria", categoria);
			request.setAttribute("categorias", categoriaDao.getAll());
			request.getRequestDispatcher(view).forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Alerta alerta = new Alerta();
		
		String paramId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
				
		Categoria categoria = new Categoria();
		
		try {
		
			int id =  Integer.parseInt(paramId);
			categoria.setId(id);
			categoria.setNombre(nombre);
			
			if ( id > 0 ) {
				categoriaDao.update(categoria);
				alerta = new Alerta("success", "Registro modificado" );
			}else {
				categoriaDao.insert(categoria);
				alerta = new Alerta("success", "Registro creado " );
			}
			
			
			
		}catch (Exception e) {
			LOG.error(e);
			alerta = new Alerta("warning", "Lo sentimos pero la categoria <b>" + categoria.getNombre() + "</b> ya esta registrada" );
			
		}finally {
			
			request.setAttribute("categoria", categoria);
			request.setAttribute("alerta", alerta);
			request.getRequestDispatcher(VIEW_FORMULARIO).forward(request, response);
		}
	}

}
