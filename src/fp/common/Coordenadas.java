package fp.common;

public record Coordenadas(Double latitud, Double longitud) {
	
	
	/**
	 * @return La latitud de las coordenadas  
	 */
	public Double getLatitud() {
		return latitud;
	}
	
	
	/**
	 * @return La longitud de las coordenadas  
	 */
	public Double getLongitud() {
		return longitud;
	}
	
	
	/**
	 * @return La distancia entre dos coordenadas 
	 */
	public Double getDistancia(Coordenadas c) {
		Double distancia = Math.sqrt(Math.pow(c.latitud - latitud, 2) + Math.pow(c.longitud - longitud, 2));
		return distancia;
	}
	
}
