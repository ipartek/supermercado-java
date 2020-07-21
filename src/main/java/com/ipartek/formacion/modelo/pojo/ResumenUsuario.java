package com.ipartek.formacion.modelo.pojo;

/**
 * Pojo para guardar datos estadisticos del Usuario.<br>
 * Los consigue mediante una VIEW de bbdd:
 * 
 * 
 * @author javaee
 *
 */
public class ResumenUsuario {
	
	
	private int idUsuario;	
	private int productosTotal;
	private int productosAprobados;
	private int productosPendientes;
	
	public ResumenUsuario() {
		super();	
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getProductosTotal() {
		return productosTotal;
	}

	public void setProductosTotal(int productosTotal) {
		this.productosTotal = productosTotal;
	}

	public int getProductosAprobados() {
		return productosAprobados;
	}

	public void setProductosAprobados(int productosAprobados) {
		this.productosAprobados = productosAprobados;
	}

	public int getProductosPendientes() {
		return productosPendientes;
	}

	public void setProductosPendientes(int productosPendientes) {
		this.productosPendientes = productosPendientes;
	}

	@Override
	public String toString() {
		return "ResumenUsuario [idUsuario=" + idUsuario + ", productosTotal=" + productosTotal + ", productosAprobados="
				+ productosAprobados + ", productosPendientes=" + productosPendientes + "]";
	}
	

}
