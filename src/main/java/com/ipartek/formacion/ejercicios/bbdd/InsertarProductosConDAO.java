package com.ipartek.formacion.ejercicios.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAO;

/**
 * 
 * 
 * Usamos executeUpdate() siempre que usamos una SQL con (INSERT, DELETE o UPDATE ) y nos retorna "int" con numero de filas afectadas 
 * 
 * @see http://www.chuidiang.org/java/mysql/EjemploJava.php 
 * @author javaee
 *
 */
public class InsertarProductosConDAO {

	
	
	public static void main(String[] args) {


		boolean continuar = true; 
		ProductoDAO dao = ProductoDAO.getInstance();				

		try( Scanner sc = new Scanner(System.in)) {	
			
			do {
				
				try {
					System.out.println("Dime el nombre del producto a guardar");
					String nombre = sc.nextLine();	
					
					Producto producto = new Producto();
					producto.setNombre(nombre);
					
					producto = dao.insert(producto);
					continuar = false;
				
				} catch (Exception e) {
					System.out.println("Lo sentimos pero el nombre ya existe, dime otro:");
					
				}
				
			} while(continuar);	
				

		} catch (Exception e) {

			System.out.println("Tenemos un problema " + e.getMessage());

		}
		
		System.out.println("Agur, nos vemos otro día");

	}

}
