package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductoDAO implements CrudAble<Producto> {
	
	private static ProductoDAO INSTANCE = null;
	
	private ProductoDAO() {
		super();	
	}
		
	public static synchronized ProductoDAO getInstance() {
		
		if ( INSTANCE == null ) {
			INSTANCE = new ProductoDAO();
		}
		
		return INSTANCE;
	}
	

	private final String SQL_GET_ALL = " SELECT id, nombre FROM producto ORDER BY id DESC; ";
	private final String SQL_INSERT = " INSERT INTO producto (nombre, id_usuario) VALUES ( ? , 1) ; ";
	//TODO resto de SQLs
	
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
				
				Producto p = new Producto(nombre);
				p.setId(id);
								
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto insert(Producto pojo) throws Exception {
		
		try(
				Connection conexion = ConnectionManager.getConnection();	
				PreparedStatement pst = conexion.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);				
				
			){
		
			pst.setString(1, pojo.getNombre() );
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
		// TODO Auto-generated method stub
		return null;
	}

	


}
