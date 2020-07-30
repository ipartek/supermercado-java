package com.ipartek.formacion.modelo.pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Producto {
	
	private int id;
	
	@NotBlank
	@Size( min = 3, max = 100, message = "La longtitud de ser entre 3 y 100 caracteres")
	private String nombre;
	
	@NotBlank ( message = "Escribe la url de la imagen")
	private String imagen;
	
	@Min( value = 0, message = "Debe ser positivo")
	private float precio;
	
	private Usuario usuario;
	
	private Categoria categoria;
	
	
	public Producto() {
		super();
		this.id = 0;
		this.nombre = "";
		this.precio = 0;
		this.imagen = "https://picsum.photos/100/100";
		this.usuario = new Usuario();
		this.categoria = new Categoria();
	}

	public Producto(String nombre) {
		this();
		this.nombre = nombre;
	}
	
	public Producto(String nombre, float precio) {
		this();
		this.nombre = nombre;
		this.precio = precio;
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


	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + ", precio=" + precio + ", usuario="
				+ usuario + ", categoria=" + categoria + "]";
	}
	

}
