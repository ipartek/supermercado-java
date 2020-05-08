package com.ipartek.formacion.fichajes.alvaro;

public class Sesion {
	
	private String nombreusuario;
	private int minutos;
	private int numConexiones;

	public Sesion() {
		super();

	}

	public String getNombreusuario() {
		return nombreusuario;
	}

	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int getNumConexiones() {
		return numConexiones;
	}

	public void setNumConexiones(int numConexiones) {
		this.numConexiones = numConexiones;
	}

}
