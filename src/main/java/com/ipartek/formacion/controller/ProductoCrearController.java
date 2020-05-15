package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOImpl;

/**
 * Servlet implementation class ProductoCrearController
 */
@WebServlet("/producto-crear")
public class ProductoCrearController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// recoger los valores del formulario
		
		//<input type="text" name="nombre" placeholder="Escribe el nombre del producto" >
		// el nombre del parametro debe coincidir con el atributo 'name' del input
		String nombre = request.getParameter("nombre");
		
		ProductoDAOImpl dao = ProductoDAOImpl.getInstance();
		
		Producto producto = new Producto();
		producto.setNombre(nombre);
		
		String mensaje = "";
		
		try {
			
			dao.insert(producto);
			mensaje = "Producto insertado con exito";
			
		} catch (Exception e) {
			
			mensaje = "Lo sentimos pero hemos tenido una Excepcion " + e.getMessage();
			e.printStackTrace();
		}
		
		// enviar datos a la vista
		request.setAttribute("mensaje", mensaje);
		

		// ir a la nueva vista o jsp
		request.getRequestDispatcher("formulario-producto.jsp").forward(request, response);
		
		
	}

}
