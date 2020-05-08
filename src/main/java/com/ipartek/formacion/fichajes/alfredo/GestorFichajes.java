package com.ipartek.formacion.fichajes.alfredo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class GestorFichajes {

	
	
	private static HashMap<String, Conexion> hmConexiones;
	
	// TODO mirar como cargar de resources
	private static final String PATH = "/home/javaee/eclipse-workspace/supermercado-java/src/main/resources/";
	private static final String[] ficheros = { "tiemposdeconexion.csv", "tiemposdeconexion.csv" };
	
	private static final String SEPARADOR = ",";
	private static final int CAMPO_NOMBRE = 0;
	private static final int CAMPO_MINUTOS = 4;

	public GestorFichajes() {
		super();
	}

	public static void main(String[] args) {
		
		BufferedReader br = null;
		String linea;
		String[] campos;

		inicializarListado();

		try {
			

			for (int i = 0; i < ficheros.length; i++) {
				
				
				// File fichero =new File(	GestorFichajes.class.getResource("tiemposdeconexion.csv").getFile());
				br = new BufferedReader(new FileReader( PATH  + ficheros[i] ));
				linea = br.readLine();

				while (linea != null) {
					campos = linea.split(SEPARADOR);
					String nombre = campos[CAMPO_NOMBRE];
					String tiempoConexion = campos[CAMPO_MINUTOS];
					int horasInt = obtenerMinutos(tiempoConexion);

					// Recorremos el listado (ya inicializado) y, si encontramos a la persona,
					// sumamos una conexión y el número de minutos
					for (Map.Entry<String, Conexion> entry : hmConexiones.entrySet()) {
						
						String clave = entry.getKey();

						// Comprobamos que el nombre recogido del csv contiene el nombre de usuario
						if (nombre.contains(clave)) {
							Conexion con = entry.getValue();
							con.incrementarConexiones();
							con.sumarMinutos(horasInt);
							hmConexiones.replace(clave, con);
							break; // Salimos del bucle porque ya hemos encontrado el alumno
						}
					}

					linea = br.readLine();
				}// while
			}

		} catch (Exception e) {
			System.out.println("Error leyendo el fichero csv");
		}

		for (Map.Entry<String, Conexion> entry : hmConexiones.entrySet()) {
			Conexion con = entry.getValue();
			System.out.println(con.getAlumno() + " | Num. conexiones: " + con.getNumConexiones() + " | Total minutos: "
					+ con.getMinutos());
		}
	}
	
	/**
	 * Consigue los minutos que hay en el String	  
	 * @param timepoConexion Cadena con los minutos, ej: "180 Minutos"
	 * @return int consgigue los minutos
	 */
	private static int obtenerMinutos ( String timepoConexion ) {
		
		char[] caracteres = timepoConexion.toCharArray();
		String horas = "0";

		for (int j = 0; j < caracteres.length; j++) {
			if (Character.isDigit(caracteres[j])) {
				horas += caracteres[j];
			}
		}

		return Integer.parseInt(horas);
		
	}

	private static void inicializarListado() {
		hmConexiones = new HashMap<String, Conexion>();
		Conexion con;

		try ( BufferedReader br = new BufferedReader(new FileReader( PATH + "lista_alumnos.csv")) ){
			
			String keyNombre = "";
			while ((  keyNombre = br.readLine()) != null) {
				con = new Conexion(keyNombre); 
				hmConexiones.put(keyNombre, con);				
			}

		} catch (Exception e) {
			System.out.println("No se ha podido leer el listado de alumnos.");
		}
	}// inicializarListado
	
}
