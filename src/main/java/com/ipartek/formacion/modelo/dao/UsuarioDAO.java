package com.ipartek.formacion.modelo.dao;

import java.util.ArrayList;

import com.ipartek.formacion.modelo.CrudAble;
import com.ipartek.formacion.modelo.pojo.Usuario;

public interface UsuarioDAO extends CrudAble<Usuario> {
	
	/**
	 * Busca alumnos que contengan la palabraBuscada
	 * @param palabraBuscada palabra a buscar
	 * @return {@code ArrayList<Alumno>}
	 * 
	 * Ej: si palabraBuscada = "a"   <br>
	 *     lista [ "ander", "pepe", "manolo"] <br>
	 *     retorna ["ander","manolo"] <br>
	 *     
	 *  SQL = SELECT id, nombre FROM alumno WHERE nombre LIKE '%a%' ORDER BY nopmbre ASC;   
	 * 
	 */
	ArrayList<Usuario> getAllByNombre( String palabraBuscada );
	
	
	/**
	 * Busca si existe el usuario en la base datsos
	 * @param nombre String nombre del usuario
	 * @param password String contraseña para acceder, cuidado que esta cifrada en MD5
	 * @return Usuario con datos si lo encuentra, si no existe retorna null
	 */
	Usuario existe ( String nombre, String password ); 
	
}
