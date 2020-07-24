package com.ipartek.formacion.controller.frontoffice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.dao.impl.ProductoDAOImpl;
import com.ipartek.formacion.modelo.pojo.ResumenUsuario;
import com.ipartek.formacion.modelo.pojo.Usuario;

/**
 * Servlet implementation class InicioController
 */
@WebServlet("/views/frontoffice/inicio")
public class InicioFrontOfficeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(InicioFrontOfficeController.class);
	private static final ProductoDAOImpl daoProducto = ProductoDAOImpl.getInstance(); 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LOG.trace("Panel de Inicio");
		
		Usuario usuarioSession = (Usuario) request.getSession().getAttribute("usuario_login");
		int idUsuario = usuarioSession.getId();
		
		// Recuperamos datos de una Tabla Virtual o View
		ResumenUsuario resumen = daoProducto.getResumenByUsuario(idUsuario);
		request.setAttribute("resumen", resumen );
		
		// CUIDADO: mirar la URL del servlet "/views/frontoffice/inicio"
		// cuando hacemos forward se pierde lo ultimo de la url y se le suma la variabel pagina
		// ----------------------------------------------------------------------------------------
		// el forward resuleve la url de la siguiente manera:
		//
		//          "/views/frontoffice/inicio" + "index.jsp"  =  "/views/frontoffice/index.jsp"
		//  ------------------------------------------------------------------------------------------
		String pagina = "index.jsp";
		LOG.debug("forward: " + pagina);
		
		request.getRequestDispatcher(pagina).forward(request, response);		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
