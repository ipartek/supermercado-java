package com.ipartek.formacion.controller.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.net.ssl.SSLEngineResult.Status;
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
import com.ipartek.formacion.modelo.dao.impl.UsuarioDAOImpl;
import com.ipartek.formacion.modelo.pojo.Producto;

/**
 * Servlet implementation class ProductoRestController
 */
@WebServlet("/api/usuario")
public class UsuarioRestController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(UsuarioRestController.class);  
	private static UsuarioDAOImpl dao = UsuarioDAOImpl.getInstance();
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LOG.debug("url pathInfo:" + request.getPathInfo() );
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");	
		
		
		String nombre = request.getParameter("nombre");
		
		//TODO llamar dao y retornar un Status u otro		
		response.setStatus( HttpServletResponse.SC_OK );
		response.setStatus( HttpServletResponse.SC_NO_CONTENT );
		
		
	}

	

}
