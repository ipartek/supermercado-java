package com.ipartek.formacion.controller.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
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
	private String responseBody;
	private int statusCode;
	

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
			
			// respuesta vacia por si no se envia nada
			responseBody = "{}";
			getIdFromPath(request.getPathInfo());
			
			super.service(request, response);  // GET, POST, PUT o DELETE
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
			LOG.error(e);
			statusCode = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
			
		}finally {
			
			// escribir respuesta
			out = response.getWriter();
			out.write( responseBody );
			response.setStatus(statusCode);
			out.flush();
			
		}
		
		
	}
	
	
	private void getIdFromPath( String pathInfo ) {						
		id = 0;		
		LOG.debug("url pathInfo:" + pathInfo );
		if ( pathInfo != null ) {
			String[] pathsParametros = pathInfo.split("/");
			if ( pathsParametros.length > 0 ) {
				id = Integer.parseInt(pathsParametros[1]);
			}
		}
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//LISTADO
		if ( id == 0 ) {
		
			ArrayList<Producto> productos = dao.getAll();			
			responseBody = new Gson().toJson(productos);
			statusCode = HttpServletResponse.SC_OK;
			LOG.debug("GET: productos recuperados " + productos.size());
			
		//DETALLE	
		}else {
			
			try {
				Producto producto = dao.getById(id);				
				responseBody = new Gson().toJson(producto);				
				statusCode = HttpServletResponse.SC_OK;
				LOG.debug("GET: detalle producto " + producto.getId() );
				
			}catch (Exception e) {
				
				statusCode = HttpServletResponse.SC_NO_CONTENT;
			}	
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Cuidado los datos ya no vienen en parametros
		// se enivan dentro del body de la request en formato json
		// hay que usar un BufferedReader para leer esa información
		
		BufferedReader bodyData = request.getReader();				
		Producto producto = new Gson().fromJson(bodyData, Producto.class);
		
		LOG.debug("POST: productos crear  " + producto);
		
		try {
			
			//TODO javax validation, si pasa las validaciones INSERT, si no 409
			
			dao.insert(producto);			
			responseBody = new Gson().toJson(producto);
			statusCode = HttpServletResponse.SC_CREATED;	
			
		}catch (Exception e) {
			LOG.error(e);
			responseBody = "{ \"error\": \"" + e.getMessage()  + "\" }";
			statusCode = HttpServletResponse.SC_CONFLICT;
		}	
		
		
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
