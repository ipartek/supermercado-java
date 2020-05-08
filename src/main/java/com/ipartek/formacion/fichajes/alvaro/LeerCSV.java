package com.ipartek.formacion.fichajes.alvaro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.Scanner;

public class LeerCSV {

	public static void main(String[] args) {
		try {
			// cargar el listado de ficheros
			String listado[] = extraerCSVs();

			HashMap<String, Sesion> mapa = new HashMap<String, Sesion>();

			for (int i = 0; i < listado.length; i++) {

				// cargar el ficehro en memoria
				File fichero = new File(LeerCSV.class.getClassLoader().getResource(listado[i]).getFile());

				Scanner sc = new Scanner(fichero);

				sc.nextLine();// saltar cabecera
				while (sc.hasNext()) {

					String linea[] = sc.nextLine().split(",");
					// sacamos los minutos y nombre
					//TODO BUG "9 Minutos"
					Integer minutos = Integer.valueOf(linea[4].substring(1, 4).trim());
					String nombre = linea[0];
					
					if (mapa.containsKey(nombre)) {
						Sesion sesion = mapa.get(nombre);
						sesion.setNumConexiones(sesion.getNumConexiones() + 1);
						sesion.setMinutos(sesion.getMinutos() + minutos);
						mapa.put(nombre, sesion);
						
					} else {
						Sesion sesion = new Sesion();
						sesion.setNombreusuario(nombre);
						sesion.setMinutos(minutos);
						sesion.setNumConexiones(1);
						mapa.put(nombre, sesion);
					}

				} // while
				sc.close();
			} // for listado de archivos

			mapa.forEach((k, v) -> System.out.println(
					"nombre: " + k + " minutos " + v.getMinutos() + " num conexiones " + v.getNumConexiones()));

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	private static String[] extraerCSVs() {

		File dir = new File(LeerCSV.class.getClassLoader().getResource("").getFile());

		String listado[] = dir.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				boolean ok = false;
				if (name.contains("csv")) {
					ok = true;
				}
				return ok;
			}
		});
		return listado;
	}

}
