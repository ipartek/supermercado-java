package com.ipartek.formacion.controller.backoffice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.ConnectionManager;

/**
 * Controlador para realizar un proceso de migracion de un fichero de texto a la base de datos.
 * Vamos a leer un txt con 10.000 personas y la vamos a insertar
 */
@WebServlet("/views/backoffice/migracion")
public class MigracionBackOfficeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(MigracionBackOfficeController.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		LOG.trace("Inicio");
		String fichero = "/home/java/personas.txt";
		int numLineas = 0;
		int numInsert = 0;
		int numErrores = 0;
		long tiempoInicio = System.currentTimeMillis();
		long tiempoFin = 0;
		
		// INSERT INTO usuario (nombre,contrasenia,id_rol) VALUES ('persona','e10adc3949ba59abbe56e057f20f883e',1);
		//final int ID_ROL_USER = 1;
		//final String PASSWORD = "e10adc3949ba59abbe56e057f20f883e"; // 123456 en MD5

		final String SQL = " INSERT INTO usuario (nombre,contrasenia,id_rol) VALUES ( ? ,'e10adc3949ba59abbe56e057f20f883e',1); ";
		
		/******** Logica de programacion **********/
		
		try ( Connection conexion = ConnectionManager.getConnection() ){
			
			LOG.trace("Leer Fichero texto");
			
			LOG.trace("Recorrer linea a linea");
			for (int i = 0; i < 5 ; i++) {
				numLineas++;
				try {
					LOG.trace("Comprobar datos correctos en la linea");
					
					
					PreparedStatement pst = conexion.prepareStatement(SQL);
					pst.setString(1, "persona" + i );
				
				
					int affectedRows = pst.executeUpdate();
					if ( affectedRows == 1 ) {
						numInsert++;
						LOG.trace("Insertada Persona");
					}else {
						numErrores++;
						LOG.trace("No se puede Insertar Persona");
					}
				}catch (Exception e) {
					// capturar posibles Excepciones para poder seguir dentro del FOR
					numErrores++;
				}	
				
			}// end for

			
			LOG.trace("Al finalizar, realizar un commit para guardar en bbdd");
			
		}catch (Exception e) {			
			LOG.error(e);
			e.printStackTrace();
			
		}finally {
			request.setAttribute("fichero", fichero);
			request.setAttribute("numero_lineas", numLineas);
			request.setAttribute("numero_insercciones", numInsert);
			request.setAttribute("numero_errores", numErrores);
			
			tiempoFin = System.currentTimeMillis();
			request.setAttribute("tiempo", (tiempoFin - tiempoInicio) );			
			
			request.getRequestDispatcher("resumen-migracion.jsp").forward(request, response);
		}
		LOG.trace("Fin");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
