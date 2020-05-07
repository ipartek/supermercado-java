package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDAOImpl implements UsuarioDAO {
	
	static final String SQL_GET_ALL_BY_NOMBRE = " SELECT id, nombre FROM usuario WHERE nombre LIKE ? ;   ";

	@Override
	public ArrayList<Usuario> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario insert(Usuario pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario update(Usuario pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Usuario> getAllByNombre(String palabraBuscada) {
		
		ArrayList<Usuario> registros = new ArrayList<Usuario>();
		
		try( Connection con = ConnectionManager.getConnection();
			 PreparedStatement pst = con.prepareStatement(SQL_GET_ALL_BY_NOMBRE);
			){
			
			pst.setString(1, "%" + palabraBuscada + "%" );
			
			try( ResultSet rs = pst.executeQuery() ){
				
				while( rs.next() ) {
					
					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");
					
					Usuario u = new Usuario();
					u.setId(id);
					u.setNombre(nombre);
					
					registros.add(u);
				}//while
				
			}//2º try
			
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return registros;
	}
	
	

}
