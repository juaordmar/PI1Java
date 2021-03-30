package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import us.lsi.math.Math2;

public class Ejercicio2 {
	public static String ejemplo2(Integer limit){
		return Stream.iterate(2, x->x<=limit, x->Math2.siguientePrimo(x))
				.map(x->x*x)
				.map(x->x.toString())
				.collect(Collectors.joining("\n"));
	}
	
	/**
	 * @param limit Un número
	 * @return Un colector que concadena los cuadrados de los primos que hay en el rango de "limit"
	 */
	
	public static String ejercicio2(Integer limit) {
		List<String> primos = new ArrayList<String>();
		Integer i = 2;
		while(i <= limit) {
			Integer p = i*i;
			primos.add(p.toString());
			i=Math2.siguientePrimo(i);
		}
		String res = String.join("\n", primos);
		return res;
	}
	
}
