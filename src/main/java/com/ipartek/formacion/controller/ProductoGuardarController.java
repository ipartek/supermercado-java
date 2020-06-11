package com.ipartek.formacion.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOImpl;

/**
 * Servlet implementation class ProductoCrearController
 */
@WebServlet("/producto")
public class ProductoGuardarController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static ProductoDAOImpl dao = ProductoDAOImpl.getInstance();
	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private static Validator validator = factory.getValidator();
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String parametroId = request.getParameter("id");
			Producto producto = new Producto();
			
			if ( parametroId != null ) {
			
				int id = Integer.parseInt(parametroId);			
				ProductoDAOImpl dao = ProductoDAOImpl.getInstance();		
				producto = dao.getById(id);
			}		
			
			request.setAttribute("producto", producto);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			// ir a la nueva vista o jsp
			request.getRequestDispatcher("formulario-producto.jsp").forward(request, response);	
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Alerta alerta = new Alerta();
		Producto producto = new Producto();		
		
		try {
			
			// recoger los valores del formulario
			String idParametro = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String precio = request.getParameter("precio");
			String imagen = request.getParameter("imagen");
			
			int id = Integer.parseInt(idParametro);
			float precioFloat = Float.parseFloat(precio);
			
			
			producto.setId(id);
			producto.setNombre(nombre);
			producto.setImagen(imagen);
			producto.setPrecio(precioFloat);
			
			
			Set<ConstraintViolation<Producto>> violations = validator.validate(producto);
			
			if ( violations.isEmpty() ) {  // sin errores de validacion, podemos guardar en bbd
				
				if ( id == 0 ) {
					dao.insert(producto);
					
				}else {
					dao.update(producto);					
				}			
			
				alerta = new Alerta( "success", "Producto guardado con exito");
				
			}else {                        // tenemos errores de validacion
				
				String errores = "";
				for (ConstraintViolation<Producto> v : violations) {					
					errores += "<p><b>" + v.getPropertyPath() + "</b>: "  + v.getMessage() + "</p>";					
				}				
				alerta = new Alerta( "danger", errores );
				
			}
		
		} catch ( SQLException e) {	
			
			alerta = new Alerta( "danger", "Lo sentimos pero ya existe ese NOMBRE, escribe otro por favor ");
			e.printStackTrace();
			
		} catch (Exception e) {
			
			alerta = new Alerta( "danger", "Lo sentimos pero hemos tenido un ERROR inxesperado ");
			e.printStackTrace();
			
		}finally {
		

			// enviar datos a la vista
			request.setAttribute("alerta", alerta);
			request.setAttribute("producto", producto);			

			// ir a la nueva vista o jsp
			request.getRequestDispatcher("formulario-producto.jsp").forward(request, response);
			
		}
		
		
		
	}//doPost

}
