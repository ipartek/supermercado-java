package com.ipartek.formacion.controller.frontoffice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.Alerta;
import com.ipartek.formacion.modelo.dao.SeguridadException;
import com.ipartek.formacion.modelo.dao.impl.ProductoDAOImpl;
import com.ipartek.formacion.modelo.pojo.Producto;
import com.ipartek.formacion.modelo.pojo.Usuario;

/**
 * Servlet implementation class EliminarFrontOfficeController
 */
@WebServlet("/views/frontoffice/eliminar")
public class EliminarFrontOfficeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(EliminarFrontOfficeController.class);
	private final static ProductoDAOImpl daoProducto = ProductoDAOImpl.getInstance();
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		LOG.trace("Entramos para eliminar producto " + paramId);	
		HttpSession session = request.getSession();
		Alerta alerta = new Alerta();
		Usuario usuario = new Usuario();
		
		try {
			
			usuario = (Usuario)session.getAttribute("usuario_login");
			int idUsuario = usuario.getId();
			int idProducto = Integer.parseInt(paramId);
			
			Producto p = daoProducto.delete(idProducto, idUsuario);			
			alerta = new Alerta("success", "Producto " + p.getNombre() + " Elimado");
			
		}catch (SeguridadException e) {
			LOG.error(" Intentan saltarse la seguridad " + usuario );
			
		}catch (Exception e) {
			LOG.error(e);
			alerta = new Alerta("danger", "Error inexsperado");
			
		}finally {
		
			session.setAttribute("alerta", alerta);		
			request.getRequestDispatcher("/views/frontoffice/inicio").forward(request, response);
		}
		
		
	}

	

}
