package com.ipartek.formacion.modelo.pojo;

/**
 * Pojo para gestionar un Usuario
 * @see com.ipartek.formacion.modelo.pojo.Rol
 * 
 * 
 * @author Ander Uraga
 * @version 1.0
 * 
 *
 */
public class Usuario {
	
	private int id;
	private String nombre;
	private String contrasenia;	
	private Rol rol;
	
	/**
	 * Construimos un usuario con id = 0 y rol = Rol.USUARIO
	 * @see com.ipartek.formacion.modelo.pojo.Rol
	 */
	public Usuario() {
		super();
		this.id = 0;
		this.nombre = "";
		this.contrasenia = "";
		this.rol = new Rol();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasenia() {
		return contrasenia;
	}


	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contrasenia=" + contrasenia + ", rol=" + rol + "]";
	}

	

}
