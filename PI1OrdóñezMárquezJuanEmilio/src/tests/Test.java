package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import us.lsi.common.Files2;
import us.lsi.geometria.Punto2D;
import ejercicios.Ejercicio1;
import ejercicios.Ejercicio2;
import ejercicios.Ejercicio3;

public class Test {
	
	public static void main(String[] args) {
		System.out.println("Test 1\n----------");
		Test.test1("../PI1OrdóñezMárquezJuanEmilio/ficheros/PI1Ej1DatosEntrada.txt");
		System.out.println("\nTest 2\n----------");
		Test.test2("../PI1OrdóñezMárquezJuanEmilio/ficheros/PI1Ej2DatosEntrada.txt");
		System.out.println("\nTest 3\n----------");
		Test.test3("../PI1OrdóñezMárquezJuanEmilio/ficheros/PI1Ej3DatosEntrada.txt");
	}
	
	public static void test1(String dirFichero) {
		System.out.println(Ejercicio1.ejercicio1(Files2.streamFromFile(dirFichero)
				.map(x->Test.parseaLinea1(x, ", ")) //x es una línea de fichero
				.collect(Collectors.toList()))); //convierto x en una List<Integer> con parseaLinea1
	}
	
	public static void test2(String dirFichero) {
		Stream<String> lineas = Files2.streamFromFile(dirFichero);
		List<Integer> limites = lineas.map(x->Test.parseaLinea2(x, ": ")).collect(Collectors.toList());
		for (int i=0; i<limites.size(); i++) {
			System.out.println("Límite "+limites.get(i)+":"+"\n"+ 
					Ejercicio2.ejercicio2(limites.get(i))+"\n\n"
					+"===========================");
		}
	}
	
	public static void test3(String dirFichero) {
		System.out.println(Ejercicio3.ejercicio3(Files2.streamFromFile(dirFichero)
				.map(x->Test.parseaLinea3(x, ", "))
				.collect(Collectors.toList())));
	}
	
	public static List<Integer> parseaLinea1(String linea, String separador){
		if(linea.equals("")) {
			return new ArrayList<Integer>();
		}
		String[] trozos = linea.split(separador); 
		List<Integer> lista = new ArrayList<Integer>();
		for(int i=0; i<trozos.length; i++) {
			Integer n = Integer.parseInt(trozos[i]); //8089 <- "8089"
			lista.add(n);
		}
		return lista;  //"8558, 3301, 7027, 8062, 9291" -> [8558, 3301, 7027, 8062, 9291]
	}
	
	public static Integer parseaLinea2(String linea, String separador) {
		if(linea.equals("")) {
			return null;
		}
		String[] elementos = linea.split(separador);
		Integer limit = Integer.parseInt(elementos[1]);
		return limit;
	}	
	
	public static Punto2D parseaLinea3(String linea, String separador){
		if(linea.equals("")) {
			return null;
		}
		String[] valores = linea.split(separador);
		Double x = Double.parseDouble(valores[0].substring(1));
		Double y = Double.parseDouble(valores[1].substring(0, valores[1].length()-1));
		return Punto2D.create(x, y);
	}

}
