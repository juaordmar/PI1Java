package ejercicios;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import us.lsi.geometria.Punto2D;
import us.lsi.geometria.Punto2D.Cuadrante;

public class Ejercicio3 {
	public static Map<Punto2D.Cuadrante,Double> ejemplo3(List<Punto2D> listaPuntos){
		return listaPuntos.stream()
				.collect(Collectors.groupingBy(Punto2D::getCuadrante,
						Collectors.<Punto2D,Double>reducing(0.,x->x.getX(),(x,y)->x+y)));
	}
	
	/**
	 * @param listaPuntos Una lista de puntos 2D
	 * @return Diccionario de la suma de las coordenadas 'x' de los puntos agrupados por cuadrante
	 */
	
	public static Map<Punto2D.Cuadrante, Double> ejercicio3(List<Punto2D> listaPuntos) {
        Integer i = 0;
        Integer tam = listaPuntos.size();
        Map<Punto2D.Cuadrante, Double> res = new HashMap<>();
        while(i<tam) {
            Punto2D punto = listaPuntos.get(i);
            Cuadrante c = punto.getCuadrante();
            Double x = punto.getX();
            if(res.containsKey(c)) {
            	res.put(c, x+res.get(c));
            }else {
            	res.put(c, x);
            }i++;
        }return res;
    }
		
}
