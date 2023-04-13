package fp.tipos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.common.Coordenadas;

public class TiroteosFatalesImpl {
	
	// Tipo contenedor
	private List<TiroteoFatalImpl> tiroteosFatales;
	
	/**
	 * Crea un objeto de tipo tiroteosFatales sin tiroteos. 
	 */
	public TiroteosFatalesImpl() {
		tiroteosFatales = new ArrayList<TiroteoFatalImpl>();
	}
	
	/**
	 * @param tiroteosFatales Colección de partidas. Crea un objeto de tipo TiroteosFatales a
	 * 		partir de una colección de tiroteos fatales. 
	 */
	public TiroteosFatalesImpl(Collection<TiroteoFatalImpl> tiroteosFatales) {
		this.tiroteosFatales = new ArrayList<TiroteoFatalImpl>(tiroteosFatales);
	}
	
	/**
	 * @param tiroteosFatales Stream de tiroteos. Crea un objeto de tipo TiroteosFatalesImpl a 
	 * 		partir de una colección de tiroteos fatales.
	 */
	public TiroteosFatalesImpl(Stream<TiroteoFatalImpl> tiroteosFatales) {
		this.tiroteosFatales = tiroteosFatales.collect(Collectors.toList());
	}

	
	
	/**
	 * @return El número de tiroteos almacenado en el objeto TiroteoFatal 
	 */
	public Integer getNumeroTiroteos() {
		return tiroteosFatales.size();
	}
	
	/**
	 * @param t tiroteo fatal
	 * Añade un tiroteo fatal al objeto 
	 */
	public void anadirTiroteo(TiroteoFatalImpl t) {
		if (!tiroteosFatales.contains(t)) {
		tiroteosFatales.add(t);
		}
	}
	
	/**
	 * @param coleccionTiroteos colección de tiroteos fatales
	 * Añade todos los tiroteos fatales en la colección al objeto 
	 */
	public void anadirTiroteos(Collection<TiroteoFatalImpl> coleccionTiroteos) {
		tiroteosFatales.addAll(coleccionTiroteos);
	}
	
	/**
	 * @param t tiroteo fatal
	 * Elimina el tiroteo pasado como parámetro 
	 */
	public void eliminaTiroteo(TiroteoFatalImpl t) {
		if(tiroteosFatales.contains(t)) {
			tiroteosFatales.remove(t);
		}
	}
	
	
	// Métodos que siguen tratamientos secuenciales
	/**
	 * FUNCION TIPO EXISTE
	 * 
	 * @param anyo Año concreto
	 * @param coste Coste de los recursoso utiliazados
	 * @return Devuelve un Booleano que nos indica si existe un tiroteo ocurrido en el año 
	 * pasado como parámetro (anyo) y con un coste de recursos utilizados superior al valor
	 * pasado como parámetro (coste). Si no hay ningún tiroteo que cumpla esta condición,
	 * devuleve false.
	 */
	public Boolean existeTiroteoAnyoCoste(Integer anyo, Double coste) {
		Boolean res = false;
		for(TiroteoFatalImpl t: tiroteosFatales) {
			if(Integer.valueOf(t.getFecha().getYear()).equals(anyo) && t.getCosteRecursos() > coste) {
				res = true;
				break;
			}
		}
		return res;
	}
	
	/**
	 * FUNCION TIPO MEDIA
	 * 
	 * @param anyo Año concreto
	 * @return  Devuelve la media de edad de las personas fallecidas en los tiroteos ocurridos 
	 * en el año pasado como parámetro (anyo).
	 */
	public Double getMediaEdadAnyo(Integer anyo) {
		Integer suma = 0;
		Integer cont = 0;
		for(TiroteoFatalImpl t: tiroteosFatales) {
			if(Integer.valueOf(t.getFecha().getYear()).equals(anyo)) {
				suma += t.getEdad();
				cont += 1;
			}
		}
		Double res;
		if(cont != 0) {
			res = Double.valueOf(suma/cont);
		}
		else {
			res = null;
		}
		return res;
	}
	
	/**
	 * FUNCION TIPO SELeCCION CON FILTRADO
	 * 
	 * @param coord Coordenas concretas
	 * @param dist Distancia
	 * @return Devuelve un conjunto con los tiroteos ocurridos en una distancia marcada por 
	 * el parámetro dist. La dsitancia con la que compararemos dist será la resultante de 
	 * hacer getDistancia() entre las coordenadas de un tiroteo y las coordenadas pasadas 
	 * como parámetro (coord).
	 */
	public Set<TiroteoFatalImpl> getTiroteosFatalesCercanosUbicacion(Coordenadas coord, Double dist){
		Set<TiroteoFatalImpl> res = new HashSet<>();
		for(TiroteoFatalImpl t: tiroteosFatales) {
			Double distancia = t.getCoordenadas().getDistancia(coord);
			if(distancia <= dist) {
				res.add(t);
			}
		}
		return res;
	}
	
	/**
	 * FUNCION TIPO MAP DE AGRUPACIÓN
	 * 
	 * @return Devuelve un Map en el que las claves son fechas y los valores son el conjunto de 
	 * tiroteos ocurridos en esa fecha.
	 */
	public Map<LocalDate, Set<TiroteoFatalImpl>> getTiroteosFatalesPorFecha(){
		 Map<LocalDate, Set<TiroteoFatalImpl>> res = new HashMap<LocalDate, Set<TiroteoFatalImpl>>();
		 
		 for(TiroteoFatalImpl t: tiroteosFatales) {
			 LocalDate key = t.getFecha();
			 if(res.containsKey(key)) {
				 res.get(key).add(t);
			 }
			 else {
				 Set<TiroteoFatalImpl> value = new HashSet<>();
				 value.add(t);
				 res.put(key, value);
			 }
		 }
		 return res;
	}
	
	/**
	 * FUNCION TIPO MAP CONTADOR (ACUMULADOR)
	 * 
	 * @return  Devuelve un Map en el que las clves son edaes y los valores son la cantidad de 
	 * tiroteos en los que ha fallecido una persona con la edad presente en la clave.
	 */
	public Map<Integer, Long> getNumeroTiroteosPorEdad(){
		Map<Integer, Long> res = new HashMap<Integer, Long>();
		
		for(TiroteoFatalImpl t: tiroteosFatales) {
			Integer key = t.getEdad();
			if(res.containsKey(key)) {
				Long value = res.get(key);
				value += 1;
				res.put(key,  value);
			}
			else {
				Long value = 1L;
				res.put(key,  value);
			}
		}
		return res;
	}
	
	
	
	// Criterio de igualdad y representación como cadena
	@Override
	public int hashCode() {
		return Objects.hash(tiroteosFatales);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TiroteosFatalesImpl other = (TiroteosFatalesImpl) obj;
		return Objects.equals(tiroteosFatales, other.tiroteosFatales);
	}

	@Override
	public String toString() {
		return "TiroteosFatalesImpl [tiroteosFatales=" + tiroteosFatales + "]";
	}
	
	
	
}
