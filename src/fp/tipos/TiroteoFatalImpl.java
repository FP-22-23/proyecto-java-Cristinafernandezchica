package fp.tipos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import fp.common.Arma;
import fp.common.Coordenadas;
import fp.common.Genero;
import fp.common.MenorMayor;
import fp.utiles.Checkers;

public class TiroteoFatalImpl implements TiroteoFatal{
	// Propiedades básicas
	private String id;
	private String nombre;
	private LocalDate fecha;
	private String maneraMorir;
	private Arma arma;
	private Integer edad;
	private Genero genero;
	private String ciudad;
	private Coordenadas coordenadas; 
	private Boolean signosEnfermedadMental;
	private Boolean camaraCuerpo;
	private List<String> policias;
	private Double costeRecursos;
	
			
	/**
	 * Constructor 1
	 * Recibe un parámetro por cada propiedad básica del tipo 
	 */
	public TiroteoFatalImpl(String id, String nombre, LocalDate fecha, String maneraMorir, Arma arma, Integer edad, 
			Genero genero, String ciudad, Coordenadas coordenadas, Boolean signosEnfermedadMental, Boolean camaraCuerpo, 
			List<String> policias, Double costeRecursos) {
		Checkers.check("Los costes no pueden ser menores o iguales a 0", costeRecursos > 0.0);
		Checkers.check("La edad no puede ser menor o igual a 0", edad > 0);
		Checkers.check("La lista no puede estar vacía", !policias.isEmpty());
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.maneraMorir = maneraMorir;
		this.arma = arma;
		this.edad = edad;
		this.genero = genero;
		this.ciudad = ciudad;
		this.coordenadas = coordenadas;
		this.signosEnfermedadMental = signosEnfermedadMental;
		this.camaraCuerpo = camaraCuerpo;
		this.policias = policias;
		this.costeRecursos = costeRecursos;
	}
						
	/**
	 * Constructor 2
	 * Un constructor a partir de String 
	 */
	public TiroteoFatalImpl(String cadena) {
		String[] trozos = cadena.split(",");
		if(trozos.length != 14) {
			throw new IllegalArgumentException("Cadena no tiene formato válido");
		}
		this.id = trozos[0].trim();
		this.nombre = trozos[1].trim();
		this.fecha = LocalDate.parse(trozos[2].trim(), DateTimeFormatter.ofPattern("d/M/y"));
		this.maneraMorir = trozos[3].trim();
		this.arma = Arma.valueOf(trozos[4].trim());
		this.edad = Integer.valueOf(trozos[5].trim());
		Checkers.check("La edad no puede ser menor o igual a 0", edad > 0);
		this.genero = Genero.valueOf(trozos[6].trim());
		this.ciudad = trozos[7].trim();
		Double latitud = Double.valueOf(trozos[8].trim());
		Double longitud = Double.valueOf(trozos[9].trim());
		Coordenadas coordenadas = new Coordenadas(latitud, longitud);
		this.coordenadas = coordenadas;
		this.signosEnfermedadMental = Boolean.valueOf(trozos[10].trim());
		this.camaraCuerpo = Boolean.valueOf(trozos[11].trim());
		String[] policia = trozos[12].split(";");
		if(policia.length != 3) {
			throw new IllegalArgumentException("La lista de policias es incorrecta solo puede contener 3 policias");
		}
		List<String> polis= new LinkedList<String>();
		polis.add(policia[0].trim());
		polis.add(policia[1].trim());
		polis.add(policia[2].trim());
		Checkers.check("La lista no puede estar vacía", !polis.isEmpty());
		this.policias = polis;
		Checkers.check("Los costes no pueden ser menores o iguales a 0", Double.valueOf(trozos[13].trim()) > 0.0);
		this.costeRecursos = Double.valueOf(trozos[13].trim());
		
		
	}
	
	
	// Propiedades derivadas
				
	/**
	 * @return Menor o Mayor en función de si es mayor o menor de edad, es decir,
	 * si es mayor de 18 años, devolverá Mayor, y si es menor de 18 años, 
	 * devolverá Menor.
	 */
	public MenorMayor menorMayor() {
		MenorMayor res = MenorMayor.Mayor;
		if(getEdad() < 18) {
			res = MenorMayor.Menor;
		}
		return res;
	}

	
	/**
	 * @return El año de nacimiento del tiroteado 
	 */
	public Integer añoNacimiento() {
		Integer res = getFecha().getYear() - getEdad();
		return res;
	}
			
	/**
	 * @return La distancia entre dos coordenadas 
	 */
	public Double getDistancia(TiroteoFatalImpl t) {
		return this.getCoordenadas().getDistancia(t.getCoordenadas());
	}
	
				
	// Métodos
	/**
	 * La documentación de los siguientes métodos está en la interfaz 
	 */
				
	public String getId() {
		return id;
	}
				
	public String getNombre() {
		return nombre;
	}		
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
				
	
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
				
	
	public String getManeraMorir() {
		return maneraMorir;
	}	
	public void setManeraMorir(String maneraMorir) {
		this.maneraMorir = maneraMorir;
	}


	public Arma getArma() {
		return arma;
	}
	public void setArma(Arma arma) {
		this.arma = arma;
	}


	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		Checkers.check("La edad no puede ser menor o igual a 0", edad > 0);
		this.edad = edad;	
	}


	public Genero getGenero() {
		return genero;
	}


	public String getCiudad() {
		return ciudad;
	}


	public Coordenadas getCoordenadas() {
		return coordenadas;
	}

				
	public Boolean getSignosEnfermedadMental() {
		return signosEnfermedadMental;
	}
	public void setSignosEnfermedadMental(Boolean signosEnfermedadMental) {
		this.signosEnfermedadMental = signosEnfermedadMental;			
	}


	public Boolean getCamaraCuerpo() {
		return camaraCuerpo;
	}
	public void setCamaraCuerpo(Boolean camaraCuerpo) {
		this.camaraCuerpo = camaraCuerpo;	
	}


	public List<String> getPolicias() {
		return policias;
		}
	public void setPolicias(List<String> policias) {
		Checkers.check("La lista no puede estar vacía", !policias.isEmpty());
		this.policias = policias;
	}


	public Double getCosteRecursos() {
		return costeRecursos;
	}
	public void setCostesRecursos(Double costeRecursos) {
		Checkers.check("Los costes no pueden ser menores o iguales a 0", costeRecursos > 0.0);
		this.costeRecursos = costeRecursos;
	}

				
				
	// Hashcode
	public int hashCode() {
		return Objects.hash(arma, camaraCuerpo, ciudad, coordenadas, costeRecursos, edad, fecha, genero, id,
				maneraMorir, nombre, policias, signosEnfermedadMental);
	}

	// Criterio de igualdad
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TiroteoFatalImpl other = (TiroteoFatalImpl) obj;
		return arma == other.arma && Objects.equals(camaraCuerpo, other.camaraCuerpo)
				&& Objects.equals(ciudad, other.ciudad) && Objects.equals(coordenadas, other.coordenadas)
				&& Objects.equals(costeRecursos, other.costeRecursos) && Objects.equals(edad, other.edad)
				&& Objects.equals(fecha, other.fecha) && genero == other.genero && Objects.equals(id, other.id)
				&& Objects.equals(maneraMorir, other.maneraMorir) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(policias, other.policias)
				&& Objects.equals(signosEnfermedadMental, other.signosEnfermedadMental);
	}


	// Representación como cadena
	public String toString() {
		return "TiroteoFatalImpl [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", maneraMorir="
				+ maneraMorir + ", arma=" + arma + ", edad=" + edad + ", genero=" + genero + ", ciudad="
				+ ciudad + ", coordenadas=" + coordenadas + ", signosEnfermedadMental=" + signosEnfermedadMental
				+ ", camaraCuerpo=" + camaraCuerpo + ", policias=" + policias + ", costeRecursos="
				+ costeRecursos + "]";
	}


	// Criterio de orden natural
	/**
	 * El criterio de orden natural (compareTo) ordenará primero por nombre del/la tiroteado/a,
	 * segundo por la fecha en que ocurrió el tiroteo, tercero por la edad del/la tirotedo/a,
	 * cuarto por la ciudad donde tuvo lugar el tiroteo y en quinto lugar y último, por los
	 * costes de los recursos utilizados. 
	 */
	public int compareTo(TiroteoFatal o) {
		int	r = this.getNombre().compareTo(o.getNombre());
			if(r == 0) {
				r = this.getFecha().compareTo(o.getFecha());
				if (r == 0) {
					r = this.getEdad().compareTo(o.getEdad());
					if(r == 0) {
						r = this.getCiudad().compareTo(o.getCiudad());
						if(r == 0) {
							r = this.getCosteRecursos().compareTo(o.getCosteRecursos());
						}
					}
				}
			}
		return r;
	}
				
				
	}
