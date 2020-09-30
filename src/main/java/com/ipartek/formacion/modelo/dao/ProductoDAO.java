package com.ipartek.formacion.modelo.dao;

import java.util.ArrayList;

import com.ipartek.formacion.modelo.CrudAble;
import com.ipartek.formacion.modelo.pojo.Producto;
import com.ipartek.formacion.modelo.pojo.ResumenUsuario;

/**
 * Hereda los metodos basicos de la interfaz CrudAble
 * Ademas definie un nuevo:  {@code ArrayList<Producto>} getAllByNombre( String nombre )
 * @author javaee
 *
 */
public interface ProductoDAO extends CrudAble<Producto> {
	
	/**
	 * Validamos el producto para que sea visible en la parte publica
	 * @param id identificador del producto
	 * 
	 */
	void validar( int id );
	
	
	/**
	 * Eliminar un registro, pero comprobamos que pertenezca a un usuario
	 * @param idProducto
	 * @param idUsuario
	 * @return Producto eliminado
	 * @throws SeguridadException Si no puede eliminar el producto porque no pertenece al usuario
	 * @throws Exception 
	 */
	Producto delete(int idProducto, int idUsuario) throws Exception, SeguridadException;
	
	
	/**
	 * Comprueba que el Producto pertenezca al Usuario
	 * @param idProducto
	 * @param idUsuario
	 * @return Producto pertenecinte al idUsuario
	 * @throws Exception por sintaxis
	 * @throws SeguridadException si no pertenece el producto al Usuario
	 */
	Producto checkSeguridad(int idProducto, int idUsuario) throws Exception, SeguridadException;
	

	/**
	 * 
	 * @param nombre
	 * @return
	 */
	ArrayList<Producto> getAllByNombre( String nombre );
	
	/**
	 * Obtiene todos los productos de un usuario, estos pueden estar validados o no
	 * @param idUsuario int identificador del usuario
	 * @param isValidado boolean true para mostrar los productos con fecha_validacion, false para mostrar los pendientes de validar
	 * @return
	 */
	ArrayList<Producto> getAllByUser( int idUsuario, boolean isValidado );
	
	
	/**
	 * Obtiene los ultimos registros ordenador por id descentente
	 * @param numReg int numero de registros a recuperar
	 * @return {@code ArrayList<Producto>}
	 */
	ArrayList<Producto> getLast( int numReg );
	
	
	/**
	 * Obtienes los productos de una Categoria
	 * @param idCategoria int identificador de la Categoria
	 * @param numReg int numero de registgros a mostrar
	 * @return {@code ArrayList<Producto>}
	 */
	ArrayList<Producto> getAllByCategoria( int idCategoria, int numReg );
	
	/**
	 * 
	 * @param precioMinimo
	 * @param precioMaximo
	 * @return
	 * @throws Exception sintaxis
	 */
	ArrayList<Producto> getAllRangoPrecio( int precioMinimo, int precioMaximo ) throws Exception;
	
	/**
	 * Obtiene datos estadisticos del Usuario y sus productos
	 * @see ResumenUsuario
	 * @return ResumenUsuario
	 */
	ResumenUsuario getResumenByUsuario( int idUsuario);
	

	/**
	 * Modifica un producto un Usuario normal, el cual no es Administrador.
	 * El producto vuelve a estar pendiente de Validación
	 * @param p Producto
	 * @return Producto validao
	 * @throws Exception sintaxis
	 * @throws SeguridadException sin permisos
	 */
	Producto updateByUser( Producto p) throws Exception, SeguridadException;
	
	
}
