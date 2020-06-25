package com.ipartek.formacion.modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.dao.CategoriaDAO;
import com.ipartek.formacion.modelo.pojo.Categoria;
import com.ipartek.formacion.modelo.pojo.Producto;

public class CategoriaDAOImpl implements CategoriaDAO {

	private static CategoriaDAOImpl INSTANCE = null;

	private CategoriaDAOImpl() {
		super();
	}

	public static synchronized CategoriaDAOImpl getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new CategoriaDAOImpl();
		}

		return INSTANCE;
	}

	// excuteQuery => ResultSet
	private final String SQL_GET_ALL = " SELECT id, nombre FROM categoria ORDER BY nombre ASC; ";
	private final String SQL_GET_ALL_WITH_PRODUCTS = " SELECT c.id 'categoria_id', c.nombre 'categoria_nombre', p.id 'producto_id', p.nombre 'producto_nombre', imagen, precio FROM producto p, categoria c WHERE p.id_categoria = c.id ORDER BY c.nombre ASC ; ";

	@Override
	public ArrayList<Categoria> getAll() {
		
		ArrayList<Categoria> registros = new ArrayList<Categoria>();

		try ( Connection conexion = ConnectionManager.getConnection();
			  PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL);
			  ResultSet rs = pst.executeQuery();
		) {

			while (rs.next()) {
				registros.add(mapper(rs));
			} // while

		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;

	}
	
	@Override
	public ArrayList<Categoria> getAllWithProducts() {	
		
		// la clave va a ser Interger id de la Categoria
		HashMap<Integer, Categoria> registros = new HashMap<Integer, Categoria>(); 

		try ( Connection conexion = ConnectionManager.getConnection();
			  PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL_WITH_PRODUCTS);
			  ResultSet rs = pst.executeQuery();
		) {
			
			System.out.println(pst);

			while (rs.next()) {
		
				int idCategoria = rs.getInt("categoria_id") ; // key del hasmap
				
				Categoria c = registros.get(idCategoria);
				
				if ( c == null ) {
					c = new Categoria();
					c.setId(idCategoria);
					c.setNombre( rs.getString("categoria_nombre"));
				}
				
				Producto p = new Producto();
				p.setId(rs.getInt("producto_id"));
				p.setNombre(rs.getString("producto_nombre"));
				p.setImagen(rs.getString("imagen"));
				p.setPrecio(rs.getFloat("precio"));
				
				// recuperos los productos y añado uno nuevo dentro de la cateegoria
				c.getProductos().add(p);
				
				// guardar en hasmap la categoria
				registros.put(idCategoria, c);
				
				
			} // while

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Categoria>(registros.values());
	}

	// TODO implementar estos metodos cuando necesitemos

	@Override
	public Categoria getById(int id) throws Exception {
		throw new Exception("Sin implementar de momento");
	}

	@Override
	public Categoria delete(int id) throws Exception {
		throw new Exception("Sin implementar de momento");
	}

	@Override
	public Categoria insert(Categoria pojo) throws Exception {
		throw new Exception("Sin implementar de momento");
	}

	@Override
	public Categoria update(Categoria pojo) throws Exception {
		throw new Exception("Sin implementar de momento");
	}

	private Categoria mapper(ResultSet rs) throws SQLException {
		Categoria c = new Categoria();
		c.setId(rs.getInt("id"));
		c.setNombre(rs.getString("nombre"));
		return c;
	}

	

}
