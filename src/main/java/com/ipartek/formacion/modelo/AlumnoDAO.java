package com.ipartek.formacion.modelo;

import java.util.ArrayList;

public interface AlumnoDAO extends CrudAble<Alumno> {
	
	/**
	 * Busca alumnos que contengan la palabraBuscada
	 * @param palabraBuscada palabra a buscar
	 * @return ArrayList<Alumno>
	 * 
	 * Ej: si palabraBuscada = "a"   <br>
	 *     lista [ "ander", "pepe", "manolo"] <br>
	 *     retorna ["ander","manolo"] <br>
	 *     
	 *  SQL = SELECT id, nombre FROM alumno WHERE nombre LIKE '%a%' ORDER BY nopmbre ASC;   
	 * 
	 */
	ArrayList<Alumno> getAllByNombre( String palabraBuscada );
	
}
