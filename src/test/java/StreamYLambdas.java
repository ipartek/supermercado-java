import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Test;

import com.ipartek.formacion.modelo.pojo.Producto;

public class StreamYLambdas {

	@Test
	public void test() {
		
		Producto p1 = new Producto("fresas", 10);
		Producto p2 = new Producto("champis", 5);
		
		ArrayList<Producto> lista = new ArrayList<Producto>();
		lista.add(p1);
		lista.add(p2);
		
		float total = 0;
		for (int i = 0; i < lista.size(); i++) {			
			total += lista.get(i).getPrecio();
		}
		
		//float totalConStream = lista.stream().mapToFloat( p -> p.getPrecio() ).sum();
		/*
		Optional<Producto> totalConStream = lista.stream().reduce((acumulador,producto)-> {
		      return acumulador + producto.getPrecio();
	    });
		*/
		assertEquals( 15 , total, 0.0001f );
		
		
		
	}

}
