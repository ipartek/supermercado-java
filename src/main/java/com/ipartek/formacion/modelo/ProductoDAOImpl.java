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
	private final String SQL_GET_ALL = " SELECT " + 
										"	 p.id     'producto_id', " + 
										"	 p.nombre 'producto_nombre', " + 
										"	 precio, " + 
										"	 imagen, " + 
										"	 c.id     'categoria_id', " + 
										"	 c.nombre 'categoria_nombre'	" + 
										" FROM producto p , categoria c " + 
										" WHERE p.id_categoria  = c.id " + 
										" ORDER BY p.id DESC LIMIT 500; ";
	
	
	private final String SQL_GET_LAST = " SELECT " + 
										"	 p.id     'producto_id', " + 
										"	 p.nombre 'producto_nombre', " + 
										"	 precio, " + 
										"	 imagen, " + 
										"	 c.id     'categoria_id', " + 
										"	 c.nombre 'categoria_nombre'	" + 
										" FROM producto p , categoria c " + 
										" WHERE p.id_categoria  = c.id " + 
										" ORDER BY p.id DESC LIMIT ? ; ";
	
	
	private final String SQL_GET_BY_CATEGORIA = " SELECT " + 
												"	 p.id     'producto_id', " + 
												"	 p.nombre 'producto_nombre', " + 
												"	 precio, " + 
												"	 imagen, " + 
												"	 c.id     'categoria_id', " + 
												"	 c.nombre 'categoria_nombre'	" + 
												" FROM producto p , categoria c " + 
												" WHERE p.id_categoria  = c.id " +
												" AND c.id = ? " +   // filtramos por el id de la categoria
												" ORDER BY p.id DESC LIMIT ? ; ";
	
	private final String SQL_GET_BY_ID = 	" SELECT " + 
													"	 p.id     'producto_id', " + 
													"	 p.nombre 'producto_nombre', " + 
													"	 precio, " + 
													"	 imagen, " + 
													"	 c.id     'categoria_id', " + 
													"	 c.nombre 'categoria_nombre'	" + 
											" FROM producto p , categoria c " + 
											" WHERE p.id_categoria  = c.id AND p.id = ? ; ";
	
	// excuteUpdate => int numero de filas afectadas
	//TODO faltan campos imagen y precio
	private final String SQL_INSERT = " INSERT INTO producto (nombre, imagen, precio , id_usuario, id_categoria ) VALUES ( ? , ?, ? , 1,  ? ) ; ";	
	private final String SQL_UPDATE = " UPDATE producto SET nombre = ?, imagen = ?, precio = ?, id_categoria = ? WHERE id = ? ; ";
	
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
				
				registros.add( mapper(rs) );
				
			} // while
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		return registros;
	}
	
	@Override
	public ArrayList<Producto> getLast(int numReg) {

		ArrayList<Producto> registros = new ArrayList<Producto>();		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_LAST);
			) {			
					pst.setInt( 1, numReg);
					System.out.println("SQL_GET_LAST: " + pst );
					try ( ResultSet rs = pst.executeQuery() ){
						while ( rs.next() ) {					
							registros.add( mapper(rs) );					
						}
					}
			
		} catch (Exception e) {			
			e.printStackTrace();			
		}
		return registros;
	}

	
	@Override
	public ArrayList<Producto> getAllByCategoria(int idCategoria, int numReg) {
		ArrayList<Producto> registros = new ArrayList<Producto>();		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_CATEGORIA);
			) {			
					pst.setInt( 1, idCategoria);
					pst.setInt( 2, numReg);
					System.out.println("SQL_GET_BY_CATEGORIA: " + pst );
					try ( ResultSet rs = pst.executeQuery() ){
						while ( rs.next() ) {					
							registros.add( mapper(rs) );					
						}
					}
			
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
					
					registro = mapper(rs);
										
					
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
			pst.setInt(4, pojo.getCategoria().getId() );
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
				pst.setInt(4, pojo.getCategoria().getId() );
				pst.setInt(5, pojo.getId() );
				
				int affectedRows = pst.executeUpdate();
				if ( affectedRows != 1 ) {
					throw new Exception("No se puede podificar el registro con id=" + pojo.getId() );
				}
				
		}
		
		return pojo;
	}

	@Override
	public ArrayList<Producto> getAllRangoPrecio(int precioMinimo, int precioMaximo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	private Producto mapper(ResultSet rs) throws SQLException {
		
		Producto p = new Producto();
		Categoria c = new Categoria();
		
		p.setId( rs.getInt("producto_id") );
		p.setNombre( rs.getString("producto_nombre"));
		p.setImagen(rs.getString("imagen"));
		p.setPrecio( rs.getFloat("precio"));
		
		c.setId(rs.getInt("categoria_id"));
		c.setNombre(rs.getString("categoria_nombre"));
		p.setCategoria(c);
				
		return p;
	}




}
