package com.ipartek.formacion.ejercicios.bbdd;

import java.util.Scanner;

import com.ipartek.formacion.modelo.dao.impl.ProductoDAOImpl;
import com.ipartek.formacion.modelo.pojo.Producto;

public class ModificarProductoPorIdConDAO {

	public static void main(String[] args) {
		
ProductoDAOImpl dao = ProductoDAOImpl.getInstance();
		
		System.out.println("Listado de productos");
		System.out.println("__________________________");
		
		for (Producto p : dao.getAll()) {
			System.out.println(p);
		}
		
		
		try( Scanner sc = new Scanner( System.in ) ){
			
			System.out.println("Dime el ID para modificar el producto");
			int id = Integer.parseInt( sc.nextLine());
			
			System.out.println("Dime el nuevo nombre:");
			String nombre = sc.nextLine();
			
			Producto p = new Producto();
			p.setId(id);
			p.setNombre(nombre);
			
			dao.update(p);
			System.out.println("Modificado con Exito");
			
							
		}catch (Exception e) {
			System.out.println( e.getMessage() );
			//e.printStackTrace();
			
		}
		
		
	}// main
	
}
