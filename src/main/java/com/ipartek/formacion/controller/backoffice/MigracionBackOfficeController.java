package com.ipartek.formacion.controller.backoffice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

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
		//final String PATH_FICHERO = "/home/javaee/eclipse-workspace/supermercado-java/src/main/resources/personas.txt";
		final String PATH_FICHERO = "personas.txt"; // busca el fichero en la carpeta => src/main/resources
		String mensaje = "";
		int numLineas = 0;
		int numInsert = 0;
		// int numErroresCampos = 0;
		ArrayList<String> lineaserroneas = new ArrayList<String>();  
		
		int numErroresNombresDuplicados = 0;
		long tiempoInicio = System.currentTimeMillis();
		long tiempoFin = 0;
		
		// INSERT INTO usuario (nombre,contrasenia,id_rol) VALUES ('persona','e10adc3949ba59abbe56e057f20f883e',1);
		//final int ID_ROL_USER = 1;
		//final String PASSWORD = "e10adc3949ba59abbe56e057f20f883e"; // 123456 en MD5

		final String SQL = " INSERT INTO usuario (nombre,contrasenia,id_rol, fecha_nacimiento) VALUES ( ? ,'e10adc3949ba59abbe56e057f20f883e',1, ?); ";
		
		/******** Logica de programacion **********/
		
	
		
		
		try ( Connection conexion = ConnectionManager.getConnection();
			  PreparedStatement pst = conexion.prepareStatement(SQL);			  
			  BufferedReader br = new BufferedReader(new FileReader(getClass().getClassLoader().getResource(PATH_FICHERO).getFile()));
		  ){
			
			// Cuando establecemos una conexion en Java, siempre es autocomitable
			// Con esta linea le decimos que no lo sea y deberemos hacer un COMMIT para guardar los cambios temporales
			conexion.setAutoCommit(false);
			String linea = br.readLine(); // obviar la 1º linea, que son la cabecera
			LOG.trace("Recorrer linea a linea, despues de saltar la 1º linea");
			
			while( (linea = br.readLine()) != null) {
				String[] campos = linea.split(";");	
				
				try {
					numLineas++;	
					if (campos.length != 6 ) {
						// numErroresCampos++;
						lineaserroneas.add( (numLineas + 1) + " - " + linea);
					}else {
					
						pst.setString(1, campos[0] );
						
						SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH); // Mar 25, 2020
					    Date fecha = sdf.parse(campos[2]);
					    LOG.debug(fecha);
					    //TODO intentar usar pst.setDate para que sea mas elegante, pero a funcionado
					    pst.setObject(2, fecha);

						
						
						LOG.debug(pst);
						int affectedRows = pst.executeUpdate();
						if ( affectedRows != 1 ) {
							//numErroresCampos++;
							lineaserroneas.add((numLineas + 1) + " - " + linea);
							LOG.warn("FALLO Inser affectedRows != 1");	
						}else {
							numInsert++;
							LOG.trace("Insertada Persona");
						}
						
					}					
				
				// capturar posibles Excepciones para poder seguir dentro del FOR				
				}catch (Exception e) {	
					LOG.warn("Nombre duplicado: " +  campos[0] );
					numErroresNombresDuplicados++;
				}	
				
			}// end while
			
			conexion.commit();
			LOG.trace("Al finalizar, realizar un commit para guardar en bbdd");
			
		}catch (FileNotFoundException e) {
			mensaje = "Lo sentimos pero el fichero no existe en la ruta: <b>" + PATH_FICHERO + "</b>";
			
		}catch (Exception e) {			
			LOG.error(e);
			mensaje = e.getMessage();
			e.printStackTrace();
			
		}finally {
			
			request.setAttribute("mensaje", mensaje);
			request.setAttribute("fichero", PATH_FICHERO);
			request.setAttribute("numero_lineas", numLineas);
			request.setAttribute("numero_insercciones", numInsert);
			//request.setAttribute("numero_errores_campos", numErroresCampos);
			request.setAttribute("lineaserroneas", lineaserroneas);			
			request.setAttribute("numero_errores_nombre", numErroresNombresDuplicados);
			
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
