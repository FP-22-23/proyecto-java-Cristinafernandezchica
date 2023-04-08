package fp.test;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import fp.common.Coordenadas;
import fp.tipos.FactoriaTiroteosFatales;
import fp.tipos.TiroteoFatalImpl;
import fp.tipos.TiroteosFatalesImpl;

public class TestTiroteosFatalesImpl {

	public static void main(String[] args) {
		TiroteosFatalesImpl tiroteosFatales = FactoriaTiroteosFatales.leerTiroteosFatales("data/fatalpoliceshootings.csv");
		
		System.out.println("\ntestExisteTiroteoAñoCoste");
		System.out.println("===========================");
		testExisteTiroteoAnyoCoste(tiroteosFatales, 2016, 2000.0);
		testExisteTiroteoAnyoCoste(tiroteosFatales, 2017, 1000.0);
		
		System.out.println("\ntestGetMediaEdadAnyo");
		System.out.println("=======================");
		testGetMediaEdadAnyo(tiroteosFatales, 2015);
		testGetMediaEdadAnyo(tiroteosFatales, 2018);
		
		System.out.println("\ntestGetTiroteosFatalesCercanosUbicacion");
		System.out.println("==========================================");
		testGetTiroteosCercanosUbicacion(tiroteosFatales, new Coordenadas(20.0,-50.0), 30.0);
		
		System.out.println("\ntestGetTiroteosFatalesPorFecha");
		System.out.println("=================================");
		testGetTiroteosFatalesPorFecha(tiroteosFatales);
		
		System.out.println("\ntestNumeroTiroteosPorEdad");
		System.out.println("============================");
		testNumeroTiroteosPorEdad(tiroteosFatales);
	
	}
	
	
	
	
	private static void testExisteTiroteoAnyoCoste(TiroteosFatalesImpl tiroteosFatales, Integer anyo, Double coste) {
		try {
			String msg = String.format("¿Hay algún tiroteo fatal sucedido en el año " + anyo + " que tengo unos coste de recursos utilizados superiores a " + coste + "?" 
		+ tiroteosFatales.existeTiroteoAnyoCoste(anyo, coste));
			System.out.println(msg);
		}
		catch (Exception e){
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
	}
	
	private static void testGetMediaEdadAnyo(TiroteosFatalesImpl tiroteosFatales, Integer anyo) {
		try {
			String msg = String.format("La media de edad de los fallecidos en los tiroteos sucedidos en el año " + anyo + " es: " 
		+ tiroteosFatales.getMediaEdadAnyo(anyo));
			System.out.println(msg);
		}
		catch (Exception e){
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
	}
	
	 private static void testGetTiroteosCercanosUbicacion(TiroteosFatalesImpl tiroteosFatales, Coordenadas coord, Double dist) {
			try {
				String msg = String.format("Los tiroteos ocurridos en una distancia menor que " + dist + " tomando como distancia a comparar la distancia entre las coordenadas" + coord + " y las coordendas del tiroteo son:");
				System.out.println(msg);
				Set<TiroteoFatalImpl> ss = tiroteosFatales.getTiroteosFatalesCercanosUbicacion(coord, dist);
				ss.stream().forEach(System.out::println);
			}
			catch (Exception e){
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}
	 }
	
	private static void testGetTiroteosFatalesPorFecha(TiroteosFatalesImpl tiroteosFatales) {
		try {
			String msg = String.format("Los tiroteos fatales por fecha son:");
			System.out.println(msg);
			Map<LocalDate, Set<TiroteoFatalImpl>> m = tiroteosFatales.getTiroteosFatalesPorFecha();
			System.out.println(m);
		} 
		catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
	}

	private static void testNumeroTiroteosPorEdad(TiroteosFatalesImpl tiroteosFatales) {
		try {
			String msg = String.format("El número de tiroteos fatales por edad es:");
			System.out.println(msg);
			Map<Integer, Long> m = tiroteosFatales.getNumeroTiroteosPorEdad();
			System.out.println(m);
		} 
		catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
	}

}
	/**
	 * Los test que están por encima de testGetTiroteosFatalesPorFecha no aparecen al ejecutar porque el map que 
	 * imprime es muy grande, si se hace por separado si que los imprime. 
	 */


