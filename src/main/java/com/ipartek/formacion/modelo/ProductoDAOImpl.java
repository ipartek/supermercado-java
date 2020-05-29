package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoDAOImpl implements ProductoDAO {
	
	private static ProductoDAOImpl INSTANCE = null;
	
	private ProductoDAOImpl() {
		super();	
	}
		
	public static synchronized ProductoDAOImpl getInstance() {
		
		if ( INSTANCE == null ) {
			INSTANCE = new ProductoDAOImpl();
		}
		
		return INSTANCE;
	}
	
	// excuteQuery => ResultSet
	private final String SQL_GET_ALL = " SELECT id, nombre, imagen, precio  FROM producto ORDER BY id DESC; ";
	private final String SQL_GET_BY_ID = " SELECT id, imagen, precio, nombre FROM producto WHERE id = ? ; ";
	
	// excuteUpdate => int numero de filas afectadas
	//TODO faltan campos imagen y precio
	private final String SQL_INSERT = " INSERT INTO producto (nombre, imagen, precio , id_usuario) VALUES ( ? , ?, ? , 1 ) ; ";	
	private final String SQL_UPDATE = " UPDATE producto SET nombre = ?, imagen = ?, precio = ? WHERE id = ? ; ";
	
	private final String SQL_DELETE = " DELETE FROM producto WHERE id = ? ; ";
	
	
	public ArrayList<Producto> getAllByNombre( String nombre ) {
		return null;
	}
	
	@Override
	public ArrayList<Producto> getAll() {
		
		ArrayList<Producto> registros = new ArrayList<Producto>();
		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();
				
			) {
			
			while ( rs.next() ) {
				
				int id        = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String foto = rs.getString("imagen");
				float precio = rs.getFloat("precio");
				
				Producto p = new Producto(nombre);
				p.setId(id);
				p.setImagen(foto);
				p.setPrecio(precio);
								
				// guardar en lista
				registros.add(p);
				
			} // while
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		return registros;
	}

	@Override
	public Producto getById(int id) throws Exception {
		Producto registro = new Producto();
		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_ID);				
			) {
			
				pst.setInt(1, id);
				ResultSet rs = pst.executeQuery();
				
				if ( rs.next() ) {
					
					registro.setId( rs.getInt("id"));
					registro.setNombre( rs.getString("nombre"));
					registro.setImagen(rs.getString("imagen"));
					registro.setPrecio(rs.getFloat("precio"));
										
					
				}else {
					throw new Exception("No se puede encontrar registro con id=" + id);					
				}
				
			
		}
		
		return registro;
	}

	@Override
	public Producto delete(int id) throws Exception {
		
		// conseguir el producto antes de Eliminar
		Producto registro =  getById(id);
		
		try(
				Connection conexion = ConnectionManager.getConnection();	
				PreparedStatement pst = conexion.prepareStatement(SQL_DELETE);				
				
			){
			
			
			pst.setInt(1, id);
			int affectedRows = pst.executeUpdate();
			
			if ( affectedRows != 1 ) {
				throw new Exception("No se puedo eliminar el registro id = " + id);				
			}
			
			
		}// try		
		
		
		
		return registro;
	}

	@Override
	public Producto insert(Producto pojo) throws Exception {
		
		try(
				Connection conexion = ConnectionManager.getConnection();	
				PreparedStatement pst = conexion.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);				
				
			){
		
			pst.setString(1, pojo.getNombre() );
			pst.setString(2, pojo.getImagen() );
			pst.setFloat(3, pojo.getPrecio() );
			int affectedRows = pst.executeUpdate();
			
			if ( affectedRows == 1 ) {
				
				//conseguir el ID
				
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
	public Producto update(Producto pojo) throws Exception {
		
		try(
				Connection conexion = ConnectionManager.getConnection();	
				PreparedStatement pst = conexion.prepareStatement(SQL_UPDATE);				
				
			){
						
				pst.setString(1, pojo.getNombre() );
				pst.setString(2, pojo.getImagen() );
				pst.setFloat(3, pojo.getPrecio() );
				pst.setInt(4, pojo.getId() );

				
				int affectedRows = pst.executeUpdate();
				if ( affectedRows != 1 ) {
					throw new Exception("No se puede podificar el registro con id=" + pojo.getId() );
				}
				
		}catch ( SQLException e) {
			
			throw new Exception("El nombre " + pojo.getNombre() + " ya existe !!!" );
		}
		
		
		return pojo;
	}

	@Override
	public ArrayList<Producto> getAllRangoPrecio(int precioMinimo, int precioMaximo) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
