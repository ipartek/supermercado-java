package com.ipartek.formacion.controller.frontoffice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.dao.impl.ProductoDAOImpl;
import com.ipartek.formacion.modelo.pojo.Producto;
import com.ipartek.formacion.modelo.pojo.Usuario;

/**
 * Servlet implementation class InicioController
 */
@WebServlet("/views/frontoffice/productos")
public class ProductosFrontOfficeController extends HttpServlet {
	
		
		private static final long serialVersionUID = 1L;
		private final static Logger LOG = Logger.getLogger(ProductosFrontOfficeController.class);
		private static final ProductoDAOImpl daoProducto = ProductoDAOImpl.getInstance(); 
	
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String validados = request.getParameter("validados");
			String titulo = "";
			ArrayList<Producto> productos = new ArrayList<Producto>();
			
			try {
				
				Usuario usuarioSession = (Usuario) request.getSession().getAttribute("usuario_login");
				int idUsuario = usuarioSession.getId();
				
				if ( validados == null ) {
					titulo = "Productos Validados";
					productos = daoProducto.getAllByUser( idUsuario, true);
				}else {
					titulo = "Productos Pendientes de Validar";
					productos = daoProducto.getAllByUser( idUsuario, false);
				}
				
				//productos = daoProducto.getAll();
				

			}catch (Exception e) {
				LOG.error(e);

			}finally {			
				request.setAttribute("productos", productos);
				request.setAttribute("titulo", titulo);			
				request.getRequestDispatcher("productos.jsp").forward(request, response);
			}	
					
			
		}
	
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
			doGet(request, response);
		}
	
	

	
}
