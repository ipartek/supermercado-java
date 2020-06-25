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
 * Servlet implementation class InicioController
 */
@WebServlet("/inicio")
public class InicioController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;	
	private static final ProductoDAOImpl productoDAO = ProductoDAOImpl.getInstance();
	private static final CategoriaDAOImpl categoriaDAO = CategoriaDAOImpl.getInstance();
	private static final String TODAS_LAS_CATEGORIAS = "-1";	
	
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
		
		
		ArrayList<Producto> productos = new ArrayList<Producto> ();
		ArrayList<Categoria> categoriasConProductos = new ArrayList<Categoria> ();
		
		String paramIdCategoria = request.getParameter("idCategoria");
		String paramCatNom =  ( request.getParameter("categoria") == null ) ? "Todas las Categorias" : request.getParameter("categoria");
		
		if ( TODAS_LAS_CATEGORIAS.equals(paramIdCategoria)) {
		
			categoriasConProductos = categoriaDAO.getAllWithProducts();
			productos = null;
			request.setAttribute("encabezado", "Todos los Productos por Categoria"  );
			
		}else {
			categoriasConProductos = null;
			
			if ( paramIdCategoria != null ) {
				
				int idCategoria = Integer.parseInt(paramIdCategoria);
				productos = productoDAO.getAllByCategoria( idCategoria, 10);
				
			}else {
				
				productos = productoDAO.getLast(10);
			}
			
			request.setAttribute("encabezado", "<b>" + productos.size() + "</b> Útimos productos de <b>" + paramCatNom + "</b>"  );	
		}
		
		request.setAttribute("productos", productos );		
		request.setAttribute("categoriasConProductos", categoriasConProductos );
		request.getRequestDispatcher("index.jsp").forward(request, response);		
		
	}
	

}
