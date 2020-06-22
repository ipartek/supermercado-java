package com.ipartek.formacion.modelo;

import java.util.ArrayList;

/**
 * Hereda los metodos basicos de la interfaz CrudAble
 * Ademas definie un nuevo:  ArrayList<Producto> getAllByNombre( String nombre )
 * @author javaee
 *
 */
public interface ProductoDAO extends CrudAble<Producto> {

	
	ArrayList<Producto> getAllByNombre( String nombre );
	
	/**
	 * Obtiene los ultimos registros ordenador por id descentente
	 * @param numReg int numero de registros a recuperar
	 * @return ArrayList<Producto>
	 */
	ArrayList<Producto> getLast( int numReg );
	
	ArrayList<Producto> getAllRangoPrecio( int precioMinimo, int precioMaximo );
	
	
}
