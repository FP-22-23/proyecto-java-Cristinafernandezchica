package fp.test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

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
		
		// Bloque I
		
		// FUNCION 1
		System.out.println("\ntestExisteTiroteoAñoCosteStream");
		System.out.println("==================================");
		testExisteTiroteoAnyoCosteStream(tiroteosFatales, 2016, 2000.0);
		testExisteTiroteoAnyoCosteStream(tiroteosFatales, 2017, 1000.0);
		
		// FUNCION 2
		System.out.println("\ntestGetMediaEdadAnyoStream");
		System.out.println("=============================");
		testGetMediaEdadAnyoStream(tiroteosFatales, 2015);
		testGetMediaEdadAnyoStream(tiroteosFatales, 2018);
		
		// FUNCION 3
		System.out.println("\ntestGetTiroteosFatalesCercanosUbicacionStream");
		System.out.println("================================================");
		testGetTiroteosCercanosUbicacionStream(tiroteosFatales, new Coordenadas(20.0,-50.0), 30.0);
		
		// FUNCION 4
		System.out.println("\ntestGetTiroteoFatalMayorCosteAnyo");
		System.out.println("=====================================");
		testGetTiroteoFatalMayorCosteAnyo(tiroteosFatales, 2015);
		testGetTiroteoFatalMayorCosteAnyo(tiroteosFatales, 2016);
		
		// FUNCION 5
		System.out.println("\ntestGetTiroteosFatalesCiudadOrdenados");
		System.out.println("=========================================");
		testGetTiroteosFatalesCiudadOrdenadosFechaEdad(tiroteosFatales, "Los Angeles");
		testGetTiroteosFatalesCiudadOrdenadosFechaEdad(tiroteosFatales, "Denver");
		
		// Bloque II
		
		// FUNCION 6
		System.out.println("\ntestGetTiroteosFatalesPorFechaStream");
		System.out.println("========================================");
		testGetTiroteosFatalesPorFechaStream(tiroteosFatales);
		
		// FUNCION 7
		System.out.println("\ntestGetConjuntoEdadesPorAnyo");
		System.out.println("================================");
		testGetConjuntoEdadesPorAnyo(tiroteosFatales);
		
		// FUNCION 8
		System.out.println("\ntestGetCosteMayorPorFecha");
		System.out.println("=============================");
		testGetCosteMayorPorFecha(tiroteosFatales);
		
		// FUNCION 9
		System.out.println("\ntestGetNPrimerosTiroteadosPorCiudad");
		System.out.println("=======================================");
		testGetNPrimerosTiroteadosPorCiudad(tiroteosFatales, 5);
		testGetNPrimerosTiroteadosPorCiudad(tiroteosFatales, 3);
		
		// FUNCION 10
		System.out.println("\ntestGetCiudadMayorNumeroTiroteosFatales");
		System.out.println("===========================================");
		testGetCiudadMayorNumeroTiroteosFatales(tiroteosFatales);
		
	}
	
	
	
	
	private static void testExisteTiroteoAnyoCoste(TiroteosFatalesImpl tiroteosFatales, Integer anyo, Double coste) {
		try {
			String msg = String.format("¿Hay algún tiroteo fatal sucedido en el año " + anyo + " que tengo unos coste de recursos utilizados superiores a " + coste + "? " 
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

	
	/**
	 * Los test que están por encima de testGetTiroteosFatalesPorFecha no aparecen al ejecutar porque el map que 
	 * imprime es muy grande, si se hace por separado si que los imprime. 
	 */
	
	
	// Bloque I
	
	// FUNCION 1
	private static void testExisteTiroteoAnyoCosteStream(TiroteosFatalesImpl tiroteosFatales, Integer anyo, Double coste) {
		try {
			String msg = String.format("¿Hay algún tiroteo fatal sucedido en el año " + anyo + " que tengo unos coste de recursos utilizados superiores a " + coste + "? " 
		+ tiroteosFatales.existeTiroteoAnyoCosteStream(anyo, coste));
			System.out.println(msg);
		}
		catch (Exception e){
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
	}
	
	// FUNCION 2
	private static void testGetMediaEdadAnyoStream(TiroteosFatalesImpl tiroteosFatales, Integer anyo) {
		try {
			String msg = String.format("La media de edad de los fallecidos en los tiroteos sucedidos en el año " + anyo + " es: " 
		+ tiroteosFatales.getMediaEdadAnyoStream(anyo));
			System.out.println(msg);
		}
		catch (Exception e){
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
	}
	
	// FUNCION 3
	 private static void testGetTiroteosCercanosUbicacionStream(TiroteosFatalesImpl tiroteosFatales, Coordenadas coord, Double dist) {
			try {
				String msg = String.format("Los tiroteos ocurridos en una distancia menor que " + dist 
						+ " tomando como distancia a comparar la distancia entre las coordenadas" + coord 
						+ " y las coordendas del tiroteo son:");
				System.out.println(msg);
				Set<TiroteoFatalImpl> ss = tiroteosFatales.getTiroteosFatalesCercanosUbicacionStream(coord, dist);
				ss.stream().forEach(System.out::println);
			}
			catch (Exception e){
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}
	 }
	 
	 // FUNCION 4
	 private static void testGetTiroteoFatalMayorCosteAnyo(TiroteosFatalesImpl tiroteosFatales, Integer anyo) {
			try {
				String msg = String.format("El tiroteo fatal del año " + anyo + " con mayor coste de recursos es: " + tiroteosFatales.getTiroteoFatalMayorCosteAnyo(anyo));
				System.out.println(msg);
			}
			catch (Exception e){
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}
		}
	
	 // FUNCION 5
	 private static void testGetTiroteosFatalesCiudadOrdenadosFechaEdad(TiroteosFatalesImpl tiroteosFatales, String ciudad) {
			try {
				String msg = String.format("La lista de tiroteos fatales ocurridos en la ciudad " + ciudad 
						+ " ordenada según la fecha en que ocurrió y la edad del/la tiroteado/a es: " 
						+ tiroteosFatales.getTiroteosFatalesCiudadOrdenadosFechaEdad(ciudad));
				System.out.println(msg);
			}
			catch (Exception e){
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}
		}
	 
	 // Bloque II
	 
	 // FUNCION 6
	 private static void testGetTiroteosFatalesPorFechaStream(TiroteosFatalesImpl tiroteosFatales) {
			try {
				String msg = String.format("Los tiroteos fatales por fecha son:");
				System.out.println(msg);
				Map<LocalDate, Set<TiroteoFatalImpl>> m = tiroteosFatales.getTiroteosFatalesPorFechaStream();
				System.out.println(m);
			} 
			catch (Exception e) {
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}
		}
	 
	 // FUNCION 7
	 private static void testGetConjuntoEdadesPorAnyo(TiroteosFatalesImpl tiroteosFatales) {
			try {
				String msg = String.format("Las edades de los/las tiroteadaos/as por año son:");
				System.out.println(msg);
				Map<Integer, Set<Integer>> m = tiroteosFatales.getConjuntoEdadesPorAnyo();
				System.out.println(m);
			} 
			catch (Exception e) {
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}
		}
	 
	 // FUNCION 8
	 private static void testGetCosteMayorPorFecha(TiroteosFatalesImpl tiroteosFatales) {
			try {
				String msg = String.format("Los costes de recursos máximo por fecha son:");
				System.out.println(msg);
				Map<LocalDate, Double> m = tiroteosFatales.getCosteMayorPorFecha();
				System.out.println(m);
			} 
			catch (Exception e) {
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}
		}
	 
	// FUNCION 9
	 private static void testGetNPrimerosTiroteadosPorCiudad(TiroteosFatalesImpl tiroteosFatales, Integer n) {
			try {
				String msg = String.format("Los " + n +" primeros tiroteados por ciudad son:");
				System.out.println(msg);
				SortedMap<String, List<String>> m = tiroteosFatales.getNPrimerosTiroteadosPorCiudad(n);  // Map o SortedMap? 
				System.out.println(m);
			} 
			catch (Exception e) {
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}
		}
	 
	 // FUNCION 10
	 private static void testGetCiudadMayorNumeroTiroteosFatales(TiroteosFatalesImpl tiroteosFatales) {
			try {
				String msg = String.format("La ciudad con un mayor número de tiroteos fatales es: " + tiroteosFatales.getCiudadMayorNumeroTiroteosFatales());
				System.out.println(msg);
			}
			catch (Exception e){
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}
		}
	 
	 
}