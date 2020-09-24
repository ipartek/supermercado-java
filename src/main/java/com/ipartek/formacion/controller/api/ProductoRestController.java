package com.ipartek.formacion.controller.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.ipartek.formacion.modelo.dao.impl.CategoriaDAOImpl;
import com.ipartek.formacion.modelo.dao.impl.ProductoDAOImpl;
import com.ipartek.formacion.modelo.pojo.Producto;

/**
 * Servlet implementation class ProductoRestController
 */
@WebServlet("/api/producto/*")
public class ProductoRestController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(ProductoRestController.class);  
	private static ProductoDAOImpl dao = ProductoDAOImpl.getInstance();
	private PrintWriter out = null;
	private int id;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		LOG.debug("Se ejecuta SOLO la 1º vez que recibe una petición");		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		LOG.debug("Se ejecuta cuando se para la App");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("Se ejecuta ANTES de GET, POST, PUT o DELETE");
		
		try {
		
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			//conseguir id de la URL si esque nos viene					
			id = 0;
			String pathInfo = request.getPathInfo();
			LOG.debug("url pathInfo:" + pathInfo );
			if ( pathInfo != null ) {
				String[] pathsParametros = pathInfo.split("/");
				if ( pathsParametros.length > 0 ) {
					id = Integer.parseInt(pathsParametros[1]);
				}
			}
			
			out = response.getWriter();
			
			super.service(request, response);  // GET, POST, PUT o DELETE
			LOG.debug("Se ejecuta DESPUES de GET, POST, PUT o DELETE");
			
			out.flush();
			
		}catch (Exception e) {
			
			e.printStackTrace();
			LOG.error(e);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}	
		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//LISTADO
		if ( id == 0 ) {
		
			ArrayList<Producto> productos = dao.getAll();
					
			Gson gson = new Gson();
			String stringBody = gson.toJson(productos);
			out.write( stringBody );
			LOG.debug("GET: productos recuperados " + productos.size());
			
			response.setStatus(HttpServletResponse.SC_OK);
			
		//DETALLE	
		}else {
			
			try {
				Producto producto = dao.getById(id);
				Gson gson = new Gson();
				String stringBody = gson.toJson(producto);	
				out.write( stringBody );
				response.setStatus(HttpServletResponse.SC_OK);
				
			}catch (Exception e) {
				response.setStatus(HttpServletResponse.SC_NO_CONTENT);
			}	
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);
	}

}
