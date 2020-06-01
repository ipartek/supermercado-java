package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		
		
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");
		String idioma = request.getParameter("idioma");
		
		
		//crear cookie de idioma
		Cookie cIdioma = new Cookie("cIdioma", idioma);
		cIdioma.setMaxAge( 60 * 1 * 60 * 24 * 365 * 5 ); // 5 años
		// guardar cookie 
		response.addCookie(cIdioma);
		
		

		HttpSession session = request.getSession();
		
		//TODO validar contra BBDD
		if ( "admin".equals(nombre) && "123456".equals(pass) ){
		
			
			session.setMaxInactiveInterval( 60 * 5 ); // 5 minutos sin peticiones, se invalida la session del usuario
			session.setAttribute("isLogeado", true );
			session.setAttribute("nombreUsuario", "Admin" );
			
			request.setAttribute("alerta", new Alerta("success", "Ongi Etorri, ya esats Logeado"));
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
			
		}else {
			
			//TODO logoout controller
			session.invalidate();
						
			request.setAttribute("alerta", new Alerta("warning", "Credenciales Incorrectas"));
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
		
		
		
		
		
	}

}
