package com.ipartek.formacion.controller.ejemplos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ipartek.formacion.modelo.dao.impl.ProductoDAOImpl;
import com.ipartek.formacion.modelo.pojo.Producto;

/**
 * Servlet implementation class EjemploRestController
 */
@WebServlet("/ejemplo-rest2")
public class EjemploRestController2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			ProductoDAOImpl dao = ProductoDAOImpl.getInstance();
			
			try {
				Producto producto = dao.getById(id);
				
				// respuesta para el body
				PrintWriter out = response.getWriter();
				
				Gson gson = new Gson();
				String stringBody = gson.toJson(producto);
				
				out.write( stringBody );
				
				out.flush();
				
				
				response.setStatus(200);
				
			}catch (Exception e) {
				response.setStatus(204);
			}	
			
	}


}
