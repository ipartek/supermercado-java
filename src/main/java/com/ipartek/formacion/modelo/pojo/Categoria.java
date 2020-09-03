package com.ipartek.formacion.modelo.pojo;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Categoria {

	private int id;
	
	@NotNull
	@NotEmpty(message = "debes de escribir un nombre")
	@Size(min = 1, max = 100, message = "la longtidud no es correcta [0-100]")
	private String nombre;
	
	private ArrayList<Producto> productos;
	
	public Categoria() {
		super();
		this.id = 0;
		this.nombre = "";
		this.productos = new ArrayList<Producto>();
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

	
	
	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
}
