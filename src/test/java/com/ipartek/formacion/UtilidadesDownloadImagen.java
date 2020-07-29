package com.ipartek.formacion;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class UtilidadesDownloadImagen {

	@Test
	public void test() {
		
		String search  = "https://lh3.googleusercontent.com/-1T7PJ9tWJP8/UgS6sP32i5I/AAAAAAAAAIs/ONFutNmka4Y/s912/Malpica.jpg";
		String nombre = "imagen_test.png";
		String path = "/home/javaee/eclipse-workspace/supermercado-java/src/main/webapp/imagenes/" + nombre;
		
		try {
			Utilidades.downloadImage(search, path);
			assertTrue( "si no lanza exception habra bajado", true);
		}catch (Exception e) {
			e.printStackTrace();
			fail("No se ha podido descragar");
		}	
		
		
		
	}

}
