package com.ipartek.formacion.fichajes.alfredo;

public class Conexion {
	
		private String alumno;
		private int numConexiones;
		private int minutos;

		public Conexion() {
			super();
		}

		public Conexion(String alumno) {
			this();
			this.alumno = alumno;
			this.numConexiones = 0;
			this.minutos = 0;
		}

		public String getAlumno() {
			return alumno;
		}

		public void setAlumno(String alumno) {
			this.alumno = alumno;
		}

		public int getNumConexiones() {
			return numConexiones;
		}

		public void setNumConexiones(int numConexiones) {
			this.numConexiones = numConexiones;
		}

		public int getMinutos() {
			return minutos;
		}

		public void setMinutos(int minutos) {
			this.minutos = minutos;
		}

		public void incrementarConexiones() {
			this.numConexiones++;
		}

		public void sumarMinutos(int minutos) {
			this.minutos += minutos;
		}
	
}
