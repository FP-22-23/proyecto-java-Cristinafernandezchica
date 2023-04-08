package fp.tipos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import fp.common.Arma;
import fp.common.Coordenadas;
import fp.common.Genero;
import fp.utiles.Checkers;

public class FactoriaTiroteosFatales {
	
	/**
	 * @param rutaFichero Nombre del fichero de datos de tiroteos fatales.
	 * @return Devuelve un objeto de tipo TiroteosFatalesImpl con los datos del fichero 
	 */
	public static TiroteosFatalesImpl leerTiroteosFatales(String rutaFichero){
		TiroteosFatalesImpl res = null;
		
		try {
			List<TiroteoFatalImpl> tiroteos = Files.lines(Paths.get(rutaFichero))
					.skip(1)
					.map(FactoriaTiroteosFatales::parseaTiroteoFatal)
					.collect(Collectors.toList());
			
			res = new TiroteosFatalesImpl(tiroteos);
		}
		catch(IOException e){
			System.out.println("No se ha encontrado el fichero" + rutaFichero);
			e.printStackTrace();
		}
		return res;
	}
	
	public static TiroteoFatalImpl parseaTiroteoFatal(String linea) {
		String[] trozos = linea.split(",");
		
		Checkers.check("La línea debe contener 14 campos", trozos.length == 14);
		String id = trozos[0].trim();
		String nombre = trozos[1].trim();
		LocalDate fecha = LocalDate.parse(trozos[2].trim(), DateTimeFormatter.ofPattern("d/M/y"));
		String maneraMorir = trozos[3].trim();
		Arma arma = Arma.valueOf(trozos[4].trim());
		Integer edad = Integer.parseInt(trozos[5].trim());
		Genero genero = Genero.valueOf(trozos[6].trim());
		String ciudad = trozos[7].trim();
		Double latitud = Double.valueOf(trozos[8].trim());
		Double longitud = Double.valueOf(trozos[9].trim());
		Coordenadas coordenadas = new Coordenadas(latitud, longitud);
		Boolean signosEnfermedadMental = parseaBooleano(trozos[10].trim());
		Boolean camaraCuerpo = parseaBooleano(trozos[11].trim());
		String[] policia = trozos[12].split(";");
		List<String> policias= new LinkedList<String>();
		policias.add(policia[0].trim());
		policias.add(policia[1].trim());
		policias.add(policia[2].trim());
		Double costeRecursos = Double.parseDouble(trozos[13].trim());
		
		return new TiroteoFatalImpl(id, nombre, fecha, maneraMorir, arma, edad, genero,
				ciudad, coordenadas, signosEnfermedadMental,
				camaraCuerpo, policias, costeRecursos);
	}
	
	
	
	private static Boolean parseaBooleano(String cadena) {
		Boolean res = null;
		if (cadena.equals("True")) {
			res = true;
		}
		else {
			res = false;
		}
		return res;
	}
	
	
	
	
}
