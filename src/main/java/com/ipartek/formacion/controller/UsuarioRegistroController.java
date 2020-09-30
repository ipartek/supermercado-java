package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.dao.impl.UsuarioDAOImpl;
import com.ipartek.formacion.modelo.pojo.Rol;
import com.ipartek.formacion.modelo.pojo.Usuario;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/registro")
public class UsuarioRegistroController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(UsuarioRegistroController.class);
	private static UsuarioDAOImpl daoUsuario = UsuarioDAOImpl.getInstance();

	/**
	 * Registrar un nuevo usuario en la bbdd Comprobamos que el nombre sea correcto
	 * y no exista en la bbdd Comprobamos que la contraseña y la RE-contraseña sean
	 * iguales Si todo va bien le redirigimos al login con un mensaje Si lago falla,
	 * le mostramos el fallo y volvemos al formulario
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOG.trace("iniciando registro");
		
		Alerta alerta = new Alerta();
		boolean isError = true;

		// recoger parametros del formulario
		String nombre = request.getParameter("nombre");		
		String pass = request.getParameter("pass");
		String repass = request.getParameter("repass");
		
		//TODO String fecha = request.getParameter("fecha");
		
		
		try {

			if (!pass.equalsIgnoreCase(repass)) {
				alerta = new Alerta("warning", "No coinciden las contraseñas");
				
			} else {

				Usuario usuario = new Usuario();
				usuario.setNombre(nombre);
				usuario.setContrasenia(pass);
				
				Rol rol = new Rol();
				rol.setId(Rol.USUARIO);
				usuario.setRol(rol);

				try {
					daoUsuario.insert(usuario);
					isError = false;
					LOG.info("usuario nuevo registrado " + usuario);

				} catch (Exception e) {
					alerta = new Alerta("warning", "Lo sentimos pero el nombre ya esta registrado");
				}

			}

		} catch (Exception e) {
			LOG.error(e);
			alerta = new Alerta("danger", e.getMessage());

		} finally {

			if (isError) {				
				request.setAttribute("nombre", nombre); // volvemos a enviar el parametro como atributo
				request.getRequestDispatcher("views/registro.jsp").forward(request, response);
				
			} else {
				alerta = new Alerta("info", "Registro realizado con exito");
				response.sendRedirect(request.getContextPath() + "/views/login.jsp");
			}
			
			request.getSession().setAttribute("alerta", alerta);
			
		} // finally

	}// doPost

}
