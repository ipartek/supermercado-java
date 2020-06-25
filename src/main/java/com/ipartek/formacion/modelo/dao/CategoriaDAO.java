package com.ipartek.formacion.modelo.dao;

import java.util.ArrayList;

import com.ipartek.formacion.modelo.CrudAble;
import com.ipartek.formacion.modelo.pojo.Categoria;

public interface CategoriaDAO extends CrudAble<Categoria> {

	
	/**
	 * Obtiene todas las categorias con sus productos asociados
	 * @return ArrayList<Categoria> ordenadas alfabeticamente
	 */
	public ArrayList<Categoria> getAllWithProducts();
	
}
