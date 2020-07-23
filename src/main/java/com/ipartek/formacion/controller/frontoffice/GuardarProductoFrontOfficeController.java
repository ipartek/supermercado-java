package com.ipartek.formacion.controller.frontoffice;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.Alerta;
import com.ipartek.formacion.modelo.dao.SeguridadException;
import com.ipartek.formacion.modelo.dao.impl.CategoriaDAOImpl;
import com.ipartek.formacion.modelo.dao.impl.ProductoDAOImpl;
import com.ipartek.formacion.modelo.pojo.Categoria;
import com.ipartek.formacion.modelo.pojo.Producto;
import com.ipartek.formacion.modelo.pojo.Usuario;

/**
 * Servlet implementation class InicioController
 */
@WebServlet("/views/frontoffice/guardar-producto")
public class GuardarProductoFrontOfficeController extends HttpServlet {
	
		
		private static final long serialVersionUID = 1L;
		private final static Logger LOG = Logger.getLogger(GuardarProductoFrontOfficeController.class);
		private final static ProductoDAOImpl daoProducto = ProductoDAOImpl.getInstance();
		private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		private static Validator validator = factory.getValidator();
	    
			
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			String paramId = request.getParameter("id");
			Producto p = new Producto();
			HttpSession session = request.getSession();			
			Usuario usuario = new Usuario();
			String view = "formulario.jsp";
			
			try {
				
				usuario = (Usuario)session.getAttribute("usuario_login");
				int idUsuario = usuario.getId();
				int idProducto = Integer.parseInt(paramId);
				
				// recuperar solo si es diferente de Cero, si id == 0 es un NUEVO producto 
				if ( idProducto != 0 ) {
					p = daoProducto.getById(idProducto, idUsuario);
				}				
				
				
			}catch (SeguridadException e) {
				view = "/views/frontoffice/inicio";
				LOG.error("SE estan saltando la seguridad " + usuario);
				
			}catch (Exception e) {
				LOG.error(e);
				
			}finally {
				request.setAttribute("producto", p);
				request.getRequestDispatcher(view).forward(request, response);
			}
				
				
				
						
			
		}
	
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			Alerta alerta = new Alerta();
			Producto producto = new Producto();					
			Usuario usuario = new Usuario();
			HttpSession session = request.getSession();	
			String view = "formulario.jsp";
			
			// recoger parametros del formulario
			String idParametro = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String precio = request.getParameter("precio");
			String imagen = request.getParameter("imagen");
			String categoriaId = request.getParameter("categoria_id");
			
			try {
			
				int idProducto = Integer.parseInt(idParametro);
				usuario = (Usuario)session.getAttribute("usuario_login");
				int idUsuario = usuario.getId();
				
				/* **************************************************************** 
				 * Comprobar Seguridad, siempre que no sea un nuevo Producto 
				 * ***************************************************************/
				if ( idProducto != 0 ) {
					producto = daoProducto.getById(idProducto, idUsuario); // lanza SeguridadException si no le pertenece el producto
				}
				
				
				int idCategoria = Integer.parseInt(categoriaId);
				float precioFloat = Float.parseFloat(precio);
				
				// crear objeto con esos parametros
				producto.setId(idProducto);
				producto.setNombre(nombre);
				producto.setImagen(imagen);
				producto.setPrecio(precioFloat);
				
				Categoria c = new Categoria();
				c.setId(idCategoria);
				producto.setCategoria(c);		
				
				// recuperar usuario de session y setearlo en el producto				
				producto.setUsuario(usuario);
				
				
				// validar pojo				
				Set<ConstraintViolation<Producto>> violations = validator.validate(producto);
				
				if ( violations.isEmpty() ) {	
					
					/* GUARDAR PRODUCTO EN BBDD */
					if ( idProducto == 0 ) {
						daoProducto.insert(producto);
					}else {
						daoProducto.update(producto);
					}
					alerta = new Alerta( "success", "Una vez creado el producto, deberas esperar unas horas hasta que se validen sus datos.");
					
				}else {
					String errores = "";
					for (ConstraintViolation<Producto> v : violations) {					
						errores += "<p><b>" + v.getPropertyPath() + "</b>: "  + v.getMessage() + "</p>";					
					}				
					alerta = new Alerta( "warning", errores );
				}
				
			}catch (SeguridadException e) {
				view = "/views/frontoffice/inicio";
				LOG.error(" Intentan saltarse la seguridad " + usuario );	
		
			}catch (Exception e) {				
				LOG.error(e);
				alerta = new Alerta( "warning", "Lo sentimos pero ese nombre ya esta registrado" );
				
			}finally {
			
				request.setAttribute("alerta", alerta);
				request.setAttribute("producto", producto);
				request.getRequestDispatcher(view).forward(request, response);
			}	
		}
	
	

	
}
