package com.ipartek.formacion.controller.frontoffice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class InicioController
 */
@WebServlet("/views/frontoffice/productos")
public class ProductosFrontOfficeController extends HttpServlet {
	
		
		private static final long serialVersionUID = 1L;
		private final static Logger LOG = Logger.getLogger(ProductosFrontOfficeController.class);
	
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String validados = request.getParameter("validados");
			String titulo = "";
			
			if ( validados == null ) {
				titulo = "Productos Validados";
			}else {
				titulo = "Productos Pendientes de Validar";
			}
			
			request.setAttribute("titulo", titulo);			
			request.getRequestDispatcher("productos.jsp").forward(request, response);		
			
		}
	
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
			doGet(request, response);
		}
	
	

	
}
