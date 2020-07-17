package com.ipartek.formacion.controller.frontoffice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.pojo.Producto;

/**
 * Servlet implementation class InicioController
 */
@WebServlet("/views/frontoffice/crear-producto")
public class CrearProductoFrontOfficeController extends HttpServlet {
	
		
		private static final long serialVersionUID = 1L;
		private final static Logger LOG = Logger.getLogger(CrearProductoFrontOfficeController.class);
	
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			// Ir al Formulario y enviamos un producto inicializado 
			Producto p = new Producto();
			
			request.setAttribute("producto", p);
			request.getRequestDispatcher("formulario.jsp").forward(request, response);		
			
		}
	
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			// recoger parametros del formulario
			
			
			// crear objeto con esos parametros
			Producto p = new Producto();
			p.setId(34);
			p.setNombre("Producto guardado");
			// validar pojo
			
			// llamar al dao
			
			//volver al formulario de nuevo
			request.setAttribute("producto", p);
			request.getRequestDispatcher("formulario.jsp").forward(request, response);
		}
	
	

	
}
