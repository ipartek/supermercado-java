package com.ipartek.formacion.ejercicios.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.pojo.Producto;



/**
 * Ejemplo de como cerrar los recursos abiertos con versiones anteriores a Java 7
 * @see https://www.arquitecturajava.com/jdbc-java-try-with-resources/
 * 
 * Usamos executeQuery() siempre que usamos una SQL con SELECT y nos retorna los resultados en ResultSet
 * 
 * @see http://www.chuidiang.org/java/mysql/EjemploJava.php
 * @author javaee
 *
 */
public class ListaProductos {

	public static void main(String[] args) {
		
		final String SQL = " SELECT id, nombre FROM producto ORDER BY id DESC; ";
				

		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL);
				ResultSet rs = pst.executeQuery();
				
			) {
			
								
			System.out.println("Listado de productos");
			System.out.println("--------------------------------------");
			
			// consultar 1 a 1 los resultados, hasta que no existan mas registros
			while ( rs.next() ) {
				
				int id        = rs.getInt("id");
				String nombre = rs.getString("nombre");
				
				Producto p = new Producto(nombre);
				p.setId(id);
								
				System.out.println(p);				
				
			} // while
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
				

	}

}
