package com.ipartek.formacion.controller.ejemplos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApartadoAController
 */
@WebServlet("/apartado-a")
public class ApartadoAController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApartadoAController() {
        super();        
    }

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
		
		
		String color = request.getParameter("color");
		
		String browser = request.getHeader("User-Agent");
		System.out.println("Navegador: " + browser);
		
		Cookie c = new Cookie("cColor", color);
		c.setMaxAge( 60 * 2 * 60 );
		
		
		response.addCookie(c);
		
		// en vez de REQUEST INTERNA con forward
		// request.getRequestDispatcher("resultadoA.jsp").forward(request, response);
		
		
		// Redireccion como RESPUESTA, el cliente automaticamente hace la 2 REQUEST a esta nueva url 
		response.sendRedirect("resultadoA.jsp");
		
		
	}

}
