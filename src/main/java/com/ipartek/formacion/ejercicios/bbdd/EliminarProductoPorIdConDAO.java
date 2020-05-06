package com.ipartek.formacion.ejercicios.bbdd;

import java.util.Scanner;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOImpl;

public class EliminarProductoPorIdConDAO {

	public static void main(String[] args) {

		ProductoDAOImpl dao = ProductoDAOImpl.getInstance();
		
		System.out.println("Listado de productos");
		System.out.println("__________________________");
		
		for (Producto p : dao.getAll()) {
			System.out.println(p);
		}
		
		
		try( Scanner sc = new Scanner( System.in ) ){
			
			System.out.println("Dime el ID para eliminar el producto");
			int id = Integer.parseInt( sc.nextLine());
			
			Producto pEliminado = dao.delete(id);
			System.out.println("Eliminado con exito " + pEliminado.getNombre() );
				
		}catch (Exception e) {
			System.out.println( e.getMessage() );
			e.printStackTrace();
			
		}
		
		

	}// main

}
