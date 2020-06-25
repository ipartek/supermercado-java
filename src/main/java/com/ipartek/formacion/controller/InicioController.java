package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.dao.impl.CategoriaDAOImpl;
import com.ipartek.formacion.modelo.dao.impl.ProductoDAOImpl;
import com.ipartek.formacion.modelo.pojo.Categoria;
import com.ipartek.formacion.modelo.pojo.Producto;

/**
 * Obtiene todos los productos categorizados para listar
 * 
 * @parametro idCategoria id categoria, si es null muestra todas, else muestra productos de esa categoria
 * @parametro categoria  nombre del categotegoria
 * 
 * 
 * @atributo encabezado titulo para h3 en index.jsp
 * @atributo categoriasConProductos ArrayList<Categoria>, que contiene tambien todos los productos de cada categoria
 * 
 * @view index.jsp
 * 
 */
@WebServlet("/inicio")
public class InicioController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String TODAS_LAS_CATEGORIAS = "-1";	
	
	private static final ProductoDAOImpl productoDAO = ProductoDAOImpl.getInstance();
	private static final CategoriaDAOImpl categoriaDAO = CategoriaDAOImpl.getInstance();
	
	
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
		
		// parametros
		String paramIdCategoria = ( request.getParameter("idCategoria") == null ) ? TODAS_LAS_CATEGORIAS : request.getParameter("idCategoria") ;
		String paramCatNom =  ( request.getParameter("categoria") == null ) ? "Todas las Categorias" : request.getParameter("categoria");
		
		// Inicializar Atributos a retornar a la vista	
		ArrayList<Categoria> categoriasConProductos = new ArrayList<Categoria> ();
		String encabezado = "";
		
		
		if ( TODAS_LAS_CATEGORIAS.equals(paramIdCategoria)) {		   		 // Todos los productos de todas las categorias
		
			//TODO ver como limitar en Java o SQL el numero de Productos 
			categoriasConProductos = categoriaDAO.getAllWithProducts();			
			encabezado = "Todos los Productos por Categoria";
			
		}else {    										                       // producto de una categoria concreta
			
			// obtengo los productos
			int idCategoria = Integer.parseInt(paramIdCategoria);
			ArrayList<Producto> productos = productoDAO.getAllByCategoria( idCategoria, 10);
				
			//crear Categoria para añadir los productos			
			Categoria c = new Categoria();			 
			c.setId(idCategoria);
			c.setNombre(paramCatNom);			
			c.setProductos(productos);
			
			// guardar en el array la categoria
			categoriasConProductos.add(c);
			
			encabezado = "<b>" + productos.size() + "</b> Útimos productos de <b>" + paramCatNom + "</b>" ;
				
		}
		
		//atributos		
		request.setAttribute("categoriasConProductos", categoriasConProductos );
		request.setAttribute("encabezado", encabezado );
		
		//forward vista
		request.getRequestDispatcher("index.jsp").forward(request, response);		
		
	}
	

}
