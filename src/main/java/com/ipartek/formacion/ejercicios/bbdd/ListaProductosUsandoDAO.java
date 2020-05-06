package com.ipartek.formacion.ejercicios.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOImpl;



/**

 *
 */
public class ListaProductosUsandoDAO {

	public static void main(String[] args) {
		
		
		ProductoDAOImpl dao = ProductoDAOImpl.getInstance();
		
		System.out.println("Listado de productos");
		System.out.println("--------------------------------------");
		
		for (Producto p : dao.getAll()) {
			System.out.println(p);
		}
		
		try( Scanner sc = new Scanner(System.in)) {
			
			System.out.println("Dime el ID del producto que deseas:");
			int id = Integer.parseInt( sc.nextLine() );
			
			
			Producto p = dao.getById(id);
			System.out.println(p);
			
		}catch (Exception e) {

			System.out.println( e.getMessage() );
		}
		
				

	}

}
