package com.pruebas.jse;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ipartek.formacion.modelo.pojo.Producto;

public class EqualsTest {

	@Test
	public void testVariablesNoPrimitivas() {
		
		String nombreA = "Iphone";
		String nombreB = "Iphone";
		
		Producto a = new Producto();
		a.setId(3);
		a.setNombre(nombreA);
		
		Producto b = new Producto();
		b.setId(3);
		b.setNombre(nombreB);
		
		// para poder comparar tenemos que sobreescribir el metodo equals dentro de la Clase Producto		
		// assertTrue( a == b );
		assertTrue ( a.equals(b));
		
				
		assertTrue( a.getNombre() == b.getNombre() );
		
	}
	
	
	@Test
	public void testVariablesPrimitivas() {
		
		int a = 2;
		int b = 2;
		assertTrue( a == b );
	}


}
