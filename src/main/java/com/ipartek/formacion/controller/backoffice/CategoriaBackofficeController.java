package com.ipartek.formacion.controller.backoffice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.dao.impl.CategoriaDAOImpl;
import com.ipartek.formacion.modelo.pojo.Categoria;

/**
 * Servlet implementation class CategoriaBackofficeController
 */
@WebServlet("/views/backoffice/categoria")
public class CategoriaBackofficeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(CategoriaBackofficeController.class);
	private static final CategoriaDAOImpl dao = CategoriaDAOImpl.getInstance();
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LOG.trace("Listado categorias");
		
		//TODO llamar a un Procedimiento almacenado
		ArrayList<Categoria> listado = dao.getAll();
		
		request.setAttribute("categorias", listado );
		
		// como el controlador escucha en la url "/views/backoffice/categoria"
		// para hacer el forward pierde la utima parte de la url "categoria" y debemos añadir la caroeta donde esta la index de las categorias
		// /views/backoffice/ + categoria/index.jsp
		request.getRequestDispatcher("categoria/index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LOG.trace("envian datos desde un formulario");
	}

}
