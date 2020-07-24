package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.dao.impl.UsuarioDAOImpl;
import com.ipartek.formacion.modelo.pojo.Rol;
import com.ipartek.formacion.modelo.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
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
		
		
		
		UsuarioDAOImpl dao = UsuarioDAOImpl.getInstance();
		Usuario usuario = dao.existe(nombre, pass);
		
		if ( usuario != null ){
			
			session.setMaxInactiveInterval( 60 * 5 ); // 5 minutos sin peticiones, se invalida la session del usuario			
			session.setAttribute("usuario_login", usuario );	// @see ListenerUsuarioLogeados => attributeAdded		
			
			request.setAttribute("alerta", new Alerta("success", "Ongi Etorri, ya estas Logeado"));
			
			if ( usuario.getRol().getId() == Rol.ADMINISTRADOR ) {		
				// request.getRequestDispatcher("views/backoffice/inicio").forward(request, response);
				response.sendRedirect("views/backoffice/inicio");
			}else {				
				//request.getRequestDispatcher("views/frontoffice/inicio").forward(request, response);
				response.sendRedirect("views/frontoffice/inicio");
			}
			
			
		}else {
			
						
			request.setAttribute("alerta", new Alerta("warning", "Credenciales Incorrectas"));
			request.getRequestDispatcher("views/login.jsp").forward(request, response);
			
		}
		
		
		
		
		
	}

}
