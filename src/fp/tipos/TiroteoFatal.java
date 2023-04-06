package fp.tipos;

import java.time.LocalDate;
import java.util.List;

import fp.common.Arma;
import fp.common.Coordenadas;
import fp.common.Genero;

public interface TiroteoFatal extends Comparable<TiroteoFatal>{
	
	/**
	 * @return El número de identificación del tiroteo (id)
	 */
	public String getId();
	
	
	/**
	 * @return El nombre del fallecido/a en el tiroteo
	 */
	public String getNombre(); 
	
	/**
	 * @param nombre Cadena que contiene un nombre
	 * Este método servirá para modoficar el nombre del fallecido
	 */
	public void setNombre(String nombre);
	
	
	/**
	 * @return La fecha en sucedió el tiroteo 
	 */
	public LocalDate getFecha();
	
	/**
	 * @param fecha Contiene una fecha de tipo LocalDate 
	 * Este método servirá para modificar la fecha
	 */
	public void setFecha(LocalDate fecha);
	
	
	/**
	 * @return La forma en que murió el/la tiroteado/a
	 */
	public String getManeraMorir();
	
	/**
	 * @param maneraMorir Contiene la manera en que murió el/la tiroteado/a
	 * Este método servirá para modificar la manera en que falleció
	 */
	public void setManeraMorir(String maneraMorir);
	
	
	/**
	 * @return El arma que portaba en el momento del tiroteo la persona fallecida 
	 */
	public Arma getArma();
	
	/**
	 * @param arma Contiene una de las posibles armas que portaba
	 * Este método servirá para modificar el arma que portaba la persona tiroteada
	 */
	public void setArma(Arma arma);
	
	
	/**
	 * @return La edad de la persona fallecida
	 */
	public Integer getEdad();
	
	/**
	 * @param edad Contine la edad del fallecido/a
	 * Este método sirve para modificar la edad del fallecido/a
	 */
	public void setEdad(Integer edad);
	
	
	/**
	 * @return El género de la persona fallecida
	 */
	public Genero getGenero();
	
	
	/**
	 * @return La ciudad donde se produjo el tiroteo
	 */
	public String getCiudad();
	
	
	/**
	 * @return Las coordenadas donde se produjo el tirteo
	 */
	public Coordenadas getCoordenadas();
	
	
	/**
	 * @return Un valor booleano que nos indica si la persona fallecida 
	 * tenia signos de enfermedad mental
	 */
	public Boolean getSignosEnfermedadMental();
	
	/**
	 * @param signosEnfermedadMental Contiene un valor booleano
	 * Este método sirve para modificar si la persona tiroteada tenía signos de enfermedad mental o no
	 */
	public void setSignosEnfermedadMental(Boolean signosEnfermedadMental);
	
	
	/**
	 * @return Un valor booleano que nos indica si los policias que actuaron portaban cámara corporal
	 */
	public Boolean getCamaraCuerpo();
	
	/**
	 * @param camaraCuerpo Contiene un valor booleano
	 * Este método sirve para modificar si los policias participantes en el tiroteo portaban cámara corporal o no
	 */
	public void setCamaraCuerpo(Boolean camaraCuerpo);
	
	
	/**
	 * @return Una lista de cadenas (String) con los policias implicados en el tiroteo
	 */
	public List<String> getPolicias();
	
	/**
	 * @param policias Contirne una lista de cadenas (String) con nombres de poicias
	 * Este método sirve para cambiar la lista de policias implicados en el tiroteo
	 */
	public void setPolicias(List<String> policias);
	
	
	/**
	 * @return El coste de los recursos utilizados durante el tiroteo
	 */
	public Double getCosteRecursos();
	
	/**
	 * @param costeRecursos Contiene un valor real con una cantidad de dinero
	 * Este método sirve para modificar el coste de los recursos utilizados en el tiroteo
	 */
	public void setCostesRecursos(Double costeRecursos);
	
	
}
