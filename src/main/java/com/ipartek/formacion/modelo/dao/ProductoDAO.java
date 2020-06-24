package com.ipartek.formacion.modelo.dao;

import java.util.ArrayList;

import com.ipartek.formacion.modelo.CrudAble;
import com.ipartek.formacion.modelo.pojo.Producto;

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
	
	
	/**
	 * Obtienes los productos de una Categoria
	 * @param idCategoria int identificador de la Categoria
	 * @param numReg int numero de registgros a mostrar
	 * @return ArrayList<Producto>
	 */
	ArrayList<Producto> getAllByCategoria( int idCategoria, int numReg );
	
	
	ArrayList<Producto> getAllRangoPrecio( int precioMinimo, int precioMaximo );
	
	
}
