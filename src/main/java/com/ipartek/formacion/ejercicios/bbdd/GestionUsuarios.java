package com.ipartek.formacion.ejercicios.bbdd;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.formacion.modelo.dao.impl.UsuarioDAOImpl;
import com.ipartek.formacion.modelo.pojo.Usuario;

/**
 * Poder ver todos los alumnos, crear nuevos, eliminar, editar y buscar por nombre
 * @author javaee
 *
 */
public class GestionUsuarios {

	static UsuarioDAOImpl dao = UsuarioDAOImpl.getInstance();
	static boolean continuar = false;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
	
		
		
		
		try {
			
			System.out.println("Menu de Opciones");
			System.out.println("------------------------------------------------------------");
			System.out.println("1. Listado de Usuarios");
			System.out.println("2. Buscar Usuario por id");
			System.out.println("3. Eliminar Usuario");
			System.out.println("4. Insertar Usuario");
			System.out.println("5. Modificar Usuario");
			System.out.println("6. Buscar Usuario por nombre");
			System.out.println("7. Cerrar el programa");
			
			System.out.println("------------------------------------------------------------");
			
			
			do {
				
				System.out.println("Por favor digite el numero de la accion que desea realizar");
				int opcion = Integer.parseInt(sc.nextLine());
				
				
				switch (opcion) {
				case 1: 
					listar();
					
					break;
				case 2:
					buscar_id();
					
					break;
					
				case 3:
					eliminar();
					
					break;
					
				case 4: 
					insertar();
					
					break;
					
				case 5:
					modificar();
					
					break;
					
				case 6:
					buscar_nombre();
					
					break;
					
				case 7:
					System.out.println("Cerrar el programa");
					System.out.println("---------------------------------------------");
					
					System.out.println("Hasta Pronto!!!");
					
					continuar = false;
					break;
					

				default:
					break;
				}
				
			} while (continuar);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}


	private static void listar() {
		ArrayList<Usuario> usuarios = dao.getAll();
		
		System.out.println("Listado de Usuario");
		System.out.println("---------------------------------------------");
		
		for (Usuario u : usuarios) {
			System.out.println(u);
		}
		
		continuar = true;
		
	}
	
	private static void buscar_id() {
		System.out.println("Buscar Usuario por id");
		System.out.println("---------------------------------------------");
		
		
		System.out.println("Listado de Usuario");
		System.out.println("---------------------------------------------");
		
		for (Usuario u : dao.getAll()) {
			System.out.println(u);
		}
		
		try{
			
			System.out.println("Dime el id del usuario que desea");
			int id = Integer.parseInt(sc.nextLine());
			
			Usuario u = dao.getById(id);
			System.out.println(u);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		continuar = true;
		
	}

	
	private static void eliminar() {
		System.out.println("Eliminar Usuario");
		System.out.println("---------------------------------------------");
		
		System.out.println("Listado de Usuarios");
		System.out.println("----------------------------------------");
		
		for (Usuario u : dao.getAll()) {
			System.out.println(u);
		}
		
		try {
			System.out.println("Dime el id para eliminar el producto");
			int id = Integer.parseInt(sc.nextLine());
			
			Usuario uEliminado = dao.delete(id);
			System.out.println("Eliminado con exito " + uEliminado.getNombre());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		continuar = true;
		
	}
	
	private static void insertar() {
		System.out.println("Insertar Usuario");
		System.out.println("---------------------------------------------");
		
		boolean continuar1 = true;
		
		try {
		
		   do {
			 
				try {
					
					  System.out.println("dime un nuevo usuario a guardar");
					   String nombre = sc.nextLine();
					   Usuario u = new Usuario();
					   u.setNombre(nombre);
					   
					   u = dao.insert(u);
					   continuar1 = false;
					   
					
				} catch (Exception e) {
					System.out.println("Lo sentimos pero el usuario ya existe, dime otro");
				} 
		   
			
		} while (continuar1);
		
		} catch (Exception e) {
			System.out.println("Tenemos un problema " + e.getMessage());
		}
		
		continuar = true;
		
	}
	
	private static void modificar() {
		System.out.println("Modificar Usuario");
		System.out.println("---------------------------------------------");
		
		System.out.println("Listado de Usuarios");
		System.out.println("----------------------------------------");

		for (Usuario u : dao.getAll()) {
			System.out.println(u);
		}

		try {
			System.out.println("Dime el id para modificar el producto");
			int id = Integer.parseInt(sc.nextLine());

			System.out.println("Dime el nuevo nombre del producto");
			String nombre = sc.nextLine();

			Usuario u = new Usuario();
			u.setId(id);
			u.setNombre(nombre);

			dao.update(u);
			System.out.println("Tu lista se ha modificado con exito");

		} catch (SQLException e) {			
			System.out.println("Nombre duplicado");
			
		} catch (Exception e) {
			System.out.println("persona no encontrada");
		}
		
		continuar = true;
		
	}
	
	
	private static void buscar_nombre() {
		System.out.println("Buscar Usuario por nombre");
		System.out.println("---------------------------------------------");
		
		
		try{
			
			System.out.println("Dime nombre a buscar:");
			String palabraBuscada = sc.nextLine();
			
			ArrayList<Usuario> registro = dao.getAllByNombre(palabraBuscada);
			//System.out.println(registro);
			
			if (registro.size() != 0) {
				
				for (Usuario u : registro) {
					System.out.println(u);
					
				}
				}else {
					System.out.println("Lo sentimos pero no hay coincidencias");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		continuar = true;
		
	}

}
