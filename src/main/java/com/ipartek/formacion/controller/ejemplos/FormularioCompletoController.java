package com.ipartek.formacion.controller.ejemplos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormularioCompletoController
 */
@WebServlet("/formulario-completo")
public class FormularioCompletoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.append("Served at: ");
		out.append(request.getContextPath());
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<String> validationes = new ArrayList<>();
		
		try {
			// Get parameters from view (form)
	        String name = request.getParameter("name");
	        String surname = request.getParameter("surname");
	        String studies = request.getParameter("studies");
	        String[] shift = request.getParameterValues("shift");
	        String gender = request.getParameter("gender");
	        String comments = request.getParameter("comments");
	        
	        
	        // logica de negocio
	        
	        if ( "".equalsIgnoreCase(name) ) {
	        	validationes.add("El NOMBRE es obligatorio");
	        }
	        
	        if ( "".equalsIgnoreCase(surname) ) {
	        	validationes.add("El APELLIDO es obligatorio");
	        }
	        
	        
	        int age = Integer.parseInt(request.getParameter("age"));        
	        if (studies.equalsIgnoreCase("u")) {
	            studies = "University";
	        } else if (studies.equalsIgnoreCase("v")) {
	            studies = "Vocational training";
	        } else {
	            studies = "Others";
	        }
	 
	        // Checking shift selected by user
	        ArrayList<String> shiftsSelected = new ArrayList<String>();
	        if ( shift != null ) {
		        for (String selection : shift) {
		 
		            if (selection.equalsIgnoreCase("ft")) {
		                shiftsSelected.add("Full time");
		            } else if (selection.equalsIgnoreCase("pt")) {
		                shiftsSelected.add("Part time");
		            } else {
		                shiftsSelected.add("Other");
		            }
		       
		        }
	        }   
	        // End shift checking
	 
	        
	        if (gender.equalsIgnoreCase("m")) {
	            gender = "Male";
	        } else if (gender.equalsIgnoreCase("f")) {
	            gender = "Female";
	        } else {
	            gender = "Other";
	        }
	 
	       
	        
	        
	 
	        // Return the values to the resume view
	        request.setAttribute("name", name);
	        request.setAttribute("surname", surname);
	        request.setAttribute("age", age);
	        request.setAttribute("studies", studies);
	        request.setAttribute("shift", shift);
	        request.setAttribute("comments", comments);
	        request.setAttribute("gender", gender);
	        request.setAttribute("shiftsSelected", shiftsSelected);
	        
		}catch (Exception e) {
			
			e.printStackTrace();
			request.setAttribute("mensaje", "Lo sentimos pero tenemos un ERROR " + e.getMessage());
			
		}finally {

	        // Send all back to the view
			
			
			if( validationes.isEmpty() ) {
				request.getRequestDispatcher("views/ejemplos/formulario-resumen.jsp").forward(request, response);	
				
			}else {
				
				request.setAttribute("validationes", validationes);
				request.getRequestDispatcher("views/ejemplos/formulario.jsp").forward(request, response);
			}
						
		}// finally
 
		
	}// doPost

}
