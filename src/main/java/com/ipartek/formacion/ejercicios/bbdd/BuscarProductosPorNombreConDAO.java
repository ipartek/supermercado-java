package com.ipartek.formacion.ejercicios.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.Producto;

public class BuscarProductosPorNombreConDAO {
	
	
	
	
	public static void main(String[] args) {

		String SQL = "SELECT id, nombre FROM producto WHERE nombre LIKE ? ;";

		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL);				
				Scanner sc = new Scanner(System.in);

		) {

			System.out.println("Dime nombre a buscar:");
			String nombreAbuscar = sc.nextLine();

			pst.setString(1, "%" + nombreAbuscar + "%");
			
			try( ResultSet rs = pst.executeQuery() ){
				
				// consultar 1 a 1 los resultados, hasta que no existan mas registros
				while (rs.next()) {
	
					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");
	
					Producto p = new Producto(nombre);
					p.setId(id);
	
					System.out.println(p);
	
				} // while
			}	

		

		} catch (Exception e) {
			
			e.printStackTrace();

		}

	}// main

 
}
