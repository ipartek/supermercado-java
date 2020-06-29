package com.ipartek.formacion.controller.ejemplos;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class FormularioValidacionEjemplo
 */
@WebServlet("/formulario-validacion-ejemplo")
public class FormularioValidacionEjemplo extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<String> validaciones = new ArrayList<String>(); 
		
		//recoger parametros
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String cars = request.getParameter("cars");
		
		
		//validar
		if ( "".equalsIgnoreCase(nombre)) {
			validaciones.add("el NOMBRE es obligatorio");
		}
		
		if ( "".equalsIgnoreCase(apellidos)) {
			validaciones.add("los APELLIDOS es obligatorio");
		}
		
		// enviar atribustos a a vista
		request.setAttribute("cars", cars);
		request.setAttribute("nombre", nombre);
		request.setAttribute("apellidos", apellidos);
		request.setAttribute("validaciones", validaciones);
		
		// ir a una vista
		if ( validaciones.isEmpty() ) {
			request.getRequestDispatcher("views/ejemplos/formulario-validacion-resumen.jsp").forward(request, response);
			
		}else {
			request.getRequestDispatcher("views/ejemplos/formulario-validacion.jsp").forward(request, response);
		}
		
		
	}

}
