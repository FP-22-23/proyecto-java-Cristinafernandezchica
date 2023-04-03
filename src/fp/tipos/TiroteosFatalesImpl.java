package fp.tipos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

	
	// Obtener numero de elementos
	public Integer getNumeroTiroteos() {
		return tiroteosFatales.size();
	}
	
	// Añadir un elemento
	public void anadirTiroteo(TiroteoFatalImpl t) {
		if (!tiroteosFatales.contains(t)) {
		tiroteosFatales.add(t);
		}
	}
	
	// Añadir una colección de elementos
	// Uno por uno (recorriendo la colección de elementos)
	public void anadirTiroteos(Collection<TiroteoFatalImpl> coleccionTiroteos) {
		for (TiroteoFatalImpl tiroteo: coleccionTiroteos) {
			if (!tiroteosFatales.contains(tiroteo)){
				tiroteosFatales.add(tiroteo);
			}
		}
	}
	
	// La colección entera
	public void anadirTiroteos2(Collection<TiroteoFatalImpl> coleccionTiroteos) {
		tiroteosFatales.addAll(coleccionTiroteos);
	}
	
	// Eliminar un elemento
	public void eliminaTiroteo(TiroteoFatalImpl t) {
		if(tiroteosFatales.contains(t)) {
			tiroteosFatales.remove(t);
		}
	}
	
	
	// Métodos que siguen tratamientos secuenciales
	
	// 1. Existe o para todo (a escoger)
	
	// 2. contador, suma o media (a escoger)
	
	// 3. selección con filtraxo
	
	// 4. método agrupación que devuelva un Map en el que las claves sean una propiedad
	// 	  del tipo base y los valores una colección (List, Set, SortedSet) de objetos del tipo base
	
	
	// 5. método de acumulación que devuelva un Map en el que las claves sean una propiedad 
	// del tipo base, y los valores el conteo o la suma de los objetos del tipo base almacenados 
	// en el contenedor que tienen como valor esa propiedad.
	
	
	
	
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
