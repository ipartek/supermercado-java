package com.ipartek.formacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ipartek.formacion.modelo.Producto;



/**
 * 
 * @see http://www.chuidiang.org/java/mysql/EjemploJava.php
 * @author javaee
 *
 */
public class ListaProductos {

	public static void main(String[] args) {

		final String URL = "jdbc:mysql://localhost/supermercado";
		final String USUARIO = "debian-sys-maint";
		final String PASS = "o8lAkaNtX91xMUcV";
		final String SQL = " SELECT id, nombre FROM producto ORDER BY id DESC; ";

		try {
			
			//comprobar que tengamos el .jar de MySQL
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Existe el .jar para mysql");
			
			// conectarnos a la bbdd supermercado			
			Connection conexion = DriverManager.getConnection ( URL, USUARIO, PASS);
			System.out.println("Conexion con exito");
			
			
			//Realizar una consulta
			PreparedStatement pst =  conexion.prepareStatement(SQL);
			ResultSet rs = pst.executeQuery();
			
			System.out.println("Listado de productos");
			System.out.println("--------------------------------------");
			
			// consultar 1 a 1 los resultados, hasta que no existan mas registros
			while ( rs.next() ) {
				
				int id        = rs.getInt("id");
				String nombre = rs.getString("nombre");
				
				Producto p = new Producto(nombre);
				p.setId(id);
				
				
				System.out.println(p);
				//System.out.println(p.toString());
				
			}
			
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		

		

	}

}
