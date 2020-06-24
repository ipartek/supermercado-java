package com.ipartek.formacion.ejercicios.bbdd;

import java.util.Scanner;

import com.ipartek.formacion.modelo.dao.impl.ProductoDAOImpl;
import com.ipartek.formacion.modelo.pojo.Producto;



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
