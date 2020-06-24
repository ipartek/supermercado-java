package com.ipartek.formacion.ejercicios.bbdd;

import java.util.ArrayList;

import com.ipartek.formacion.modelo.dao.impl.UsuarioDAOImpl;
import com.ipartek.formacion.modelo.pojo.Usuario;

public class BuscarAlumnosPorNombre {

	public static void main(String[] args) {
	
		
		UsuarioDAOImpl dao = UsuarioDAOImpl.getInstance();
		
		ArrayList<Usuario> lista = dao.getAllByNombre("MANOLO");
		

		if ( lista.size() == 0 ) {
			System.out.println("Lo sentimos pero no hay coincidencias");
			
		}else {

			for (Usuario usuario : lista) {
				System.out.println(usuario);
			}
			
		}
		

	}

}
