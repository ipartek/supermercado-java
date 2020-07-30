package com.ipartek.formacion.controller.backoffice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ipartek.formacion.Utilidades;
import com.ipartek.formacion.modelo.dao.impl.CategoriaDAOImpl;
import com.ipartek.formacion.modelo.dao.impl.ProductoDAOImpl;
import com.ipartek.formacion.modelo.pojo.Categoria;
import com.ipartek.formacion.modelo.pojo.Producto;
import com.ipartek.formacion.modelo.pojo.Usuario;

/**
 * Servlet implementation class CrawlerController
 */
@WebServlet("/views/backoffice/crawler")
public class CrawlerController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(CrawlerController.class);
	private final static CategoriaDAOImpl daoCategoria = CategoriaDAOImpl.getInstance();
	private final static ProductoDAOImpl daoProducto = ProductoDAOImpl.getInstance();
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("inicio");
		request.setAttribute("categorias", daoCategoria.getAll() );
		request.getRequestDispatcher("crawler.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cont = 0;
		int contError = 0;
		Usuario usuario = null;
				
		String cat = request.getParameter("cat");
		String url = request.getParameter("url");
		LOG.trace( String.format("parametros url %s categoriaId %s", url, cat));
		
		try {
			
			int idCategoria = Integer.parseInt(cat);
			usuario = (Usuario)request.getSession().getAttribute("usuario_login");
			
			final String USER_AGENT = "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:79.0) Gecko/20100101 Firefox/79.0"; 
			Document doc = Jsoup.connect(url).userAgent(USER_AGENT).get();			
			Elements eNombres = doc.select("a.product");
			Producto p = null;
			Categoria c = null;
			Usuario u = null;
			for (Element element : eNombres) {
				
				try {
					String nombre = element.select("span.desc-height strong").first().text();				
					
					String precioInicio = element.select("span.price-height span b").last().text().replace("*", "");  // 9.88*
					float precio = Float.parseFloat(precioInicio);
					
					// Imagen
					String imagenUrl = element.select("img").attr("src");
					String[] imagenSplit = imagenUrl.split("/");
					String imagenNombre = imagenSplit[ (imagenSplit.length -1 )];
					
					String urlImagen = "https://www.lidl.es" + imagenUrl;
					String pathImagen = "/home/javaee/eclipse-workspace/supermercado-java/src/main/webapp/imagenes/" + imagenNombre;
					Utilidades.downloadImage( urlImagen, pathImagen);
					
					
					// guardar pojo
					p = new Producto();
					p.setNombre(nombre);
					p.setImagen(imagenNombre);
					p.setPrecio(precio);
					
					c = new Categoria();
					c.setId(idCategoria);
					p.setCategoria(c);
					
					u = new Usuario();
					u.setId( usuario.getId() );
					p.setUsuario(u);
					
					daoProducto.insert(p);
					
					LOG.debug("Insertado Producto " + p);
					cont++;
				}catch (Exception e) {
					LOG.error(e.getMessage());
					contError++;
				}	
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			
		}finally {
			request.setAttribute("contError", contError);
			request.setAttribute("cont", cont );
			request.setAttribute("categorias", daoCategoria.getAll() );
			request.getRequestDispatcher("crawler.jsp").forward(request, response);
		}
		
		
	}

}
