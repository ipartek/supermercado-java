package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.dao.impl.ProductoDAOImpl;
import com.ipartek.formacion.modelo.pojo.Producto;

/**
 * Servlet implementation class ProductoEliminarController
 */
@WebServlet("/producto-eliminar")
public class ProductoEliminarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// <td><a href="producto-eliminar?id=${p.id}">ELIMINAR</a></td>
		// recoger parametro
		String parametroId = request.getParameter("id");
		int id = Integer.parseInt(parametroId);
		
		// llamr modelo
		ProductoDAOImpl dao = ProductoDAOImpl.getInstance();
		String mensaje  = "";
		Producto p = new Producto();
		
		try {
			p = dao.delete(id);
			mensaje = "Eliminado " + p.getNombre();
			
		} catch (Exception e) {
			mensaje = "Error " + e.getMessage();
			e.printStackTrace();
		}finally {
		
			// guardar datos en session para el mensaje de la vista
			request.getSession().setAttribute("alerta", new Alerta("success", mensaje ) );
			
			// pedimos al cliente que realize una segunda REQUEST
			response.sendRedirect("productos");
		}
		
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
