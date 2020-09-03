package com.ipartek.formacion.modelo.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.dao.CategoriaDAO;
import com.ipartek.formacion.modelo.pojo.Categoria;
import com.ipartek.formacion.modelo.pojo.Producto;

public class CategoriaDAOImpl implements CategoriaDAO {

	private static CategoriaDAOImpl INSTANCE = null;
	private final static Logger LOG = Logger.getLogger(CategoriaDAOImpl.class);

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
	// private final String SQL_GET_ALL = " SELECT id, nombre FROM categoria ORDER BY nombre ASC; ";
	
	// CUIDADO: que la llamada a los procedimientos en Java deben ir entra {} llaves
	private final String PA_GET_ALL = " { CALL pa_categoria_listar() }  ";
	
	
	private final String SQL_GET_ALL_WITH_PRODUCTS = " SELECT c.id 'categoria_id', c.nombre 'categoria_nombre', p.id 'producto_id', p.nombre 'producto_nombre', imagen, precio FROM producto p, categoria c WHERE p.id_categoria = c.id AND p.fecha_validado IS NOT NULL ORDER BY c.nombre ASC ; ";
	
	//private final String SQL_GET_BY_ID = " SELECT id, nombre FROM categoria WHERE id = ?; ";	
	private final String PA_GET_BY_ID = " { CALL pa_categoria_por_id(?) } ";

	//exceuteUpdate => int affectedRows
	
	
	//TODO para el final, cuando montemos el formulario
	private final String SQL_INSERT = " INSERT INTO categoria ( nombre ) VALUES ( ? ) ; ";	
	private final String SQL_UPDATE = " UPDATE categoria SET nombre = ?  WHERE id = ? ; ";
	
	/*
	private final String SQL_DELETE = " DELETE FROM categoria WHERE id = ? ; ";
	*/
	
	
	private final String PA_INSERT = " { CALL pa_categoria_insertar(?,?) } ";
	private final String PA_UPDATE = " { CALL pa_categoria_update(?,?) } ";	
	private final String PA_DELETE = " { CALL pa_categoria_delete(?) } ";
	
	@Override
	public ArrayList<Categoria> getAll() {
		
		ArrayList<Categoria> registros = new ArrayList<Categoria>();

		try ( Connection conexion = ConnectionManager.getConnection();
			  // PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL);
			  CallableStatement cs = conexion.prepareCall(PA_GET_ALL);
			  ResultSet rs = cs.executeQuery();
		) {

			LOG.debug(cs);
			while (rs.next()) {
				registros.add(mapper(rs));
			} // while

		} catch (Exception e) {
			LOG.error(e);
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
			
			LOG.debug(pst);
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
			LOG.error(e);
		}
		return new ArrayList<Categoria>(registros.values());
	}

	

	@Override
	public Categoria getById(int id) throws Exception {
		
		Categoria registro = new Categoria();		
		try (
				Connection conexion = ConnectionManager.getConnection();
				// PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_ID);
				CallableStatement cs = conexion.prepareCall(PA_GET_BY_ID);
			) {
			
				cs.setInt(1, id);
				LOG.debug(cs);
				ResultSet rs = cs.executeQuery();
				
				if ( rs.next() ) {					
					registro = mapper(rs);
				}else {
					throw new Exception("No se puede encontrar registro con id=" + id);					
				}	
		}
		
		return registro;
	}

	@Override
	public Categoria delete(int id) throws Exception {
		
		Categoria pojo = null;
		
		try(
				Connection conexion = ConnectionManager.getConnection();	
				CallableStatement cs = conexion.prepareCall(PA_DELETE);
			){
				// recuperar antes de eliminar
				pojo = getById(id);
			
				// eliminar
				cs.setInt(1, id );			
				LOG.debug(cs);
				cs.executeUpdate();	
			
		}
		
		return pojo;
	}

	@Override
	public Categoria insert(Categoria pojo) throws Exception {
		
		try(
				Connection conexion = ConnectionManager.getConnection();	
				PreparedStatement pst = conexion.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);				
			){
		
				pst.setString(1, pojo.getNombre() );			
				LOG.debug(pst);
				
				int affectedRows = pst.executeUpdate();			
				if ( affectedRows == 1 ) {					
					try( ResultSet rsKeys = pst.getGeneratedKeys() ){						
						if ( rsKeys.next() ) {
							int id = rsKeys.getInt(1);
							pojo.setId(id);
						}						
					}				
					
			}else {				
				throw new Exception("No se ha podido guardar el registro " + pojo );
			}
		}
		
		return pojo;
	}

	@Override
	public Categoria update(Categoria pojo) throws Exception {

		try(
				Connection conexion = ConnectionManager.getConnection();	
				PreparedStatement pst = conexion.prepareStatement(SQL_UPDATE);				
				
			){
						
				pst.setString(1, pojo.getNombre() );				
				pst.setInt(2, pojo.getId() );
				LOG.debug(pst);
				int affectedRows = pst.executeUpdate();
				if ( affectedRows != 1 ) {
					throw new Exception("No se puede podificar el registro con id=" + pojo.getId() );
				}
		}		
		return pojo;
	}

	private Categoria mapper(ResultSet rs) throws SQLException {
		Categoria c = new Categoria();
		c.setId(rs.getInt("id"));
		c.setNombre(rs.getString("nombre"));
		return c;
	}

	

}
