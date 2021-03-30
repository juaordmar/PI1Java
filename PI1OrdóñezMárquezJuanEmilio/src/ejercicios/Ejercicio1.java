package ejercicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.math.Math2;

public class Ejercicio1 {

	public static List<Integer> ejemplo1(List<List<Integer>> listas){
		return listas
				.stream()
				.flatMap(lista->lista.stream())
				.filter(e->(Math2.esPrimo(e)))
				.collect(Collectors.toList());
	}
	
	/**
	 * @param listas Una lista de listas de enteros
	 * @return La lista con los primos de la lista aplanada
	 */
	
	public static List<Integer> ejercicio1(List<List<Integer>> listas){
		List<Integer> res = new ArrayList<>();
		int i = 0;
		while(i < listas.size()) {
			Iterator<Integer> ite = listas.get(i).iterator();
			while(ite.hasNext()) {
				Integer n = ite.next();
				if(Math2.esPrimo(n)) {
					res.add(n);
				}
			}i++;
		}return res;
	}
		
}
