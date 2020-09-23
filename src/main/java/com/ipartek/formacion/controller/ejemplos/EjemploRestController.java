package com.ipartek.formacion.controller.ejemplos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EjemploRestController
 */
@WebServlet("/ejemplo-rest")
public class EjemploRestController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			// para escribir la respuesta en el BODY
			PrintWriter out = response.getWriter();
			
			/*
			 * {
				   "id": 5,
				   "nombre": "Gazpacho",
				   "precio": 2.34
				}
			 * 
			 */
			
			out.print("{");
				out.print("\"id\": 5,");
				out.print("\"nombre\": \"Gazpacho\",");
				out.print("\"precio\": 2.34");
			out.print("}");
			
			
			// vaciar el buffer
			out.flush();
			
			
			// Codido de estado, TODO usar constante
			response.setStatus(HttpServletResponse.SC_OK);
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);
	}

}
