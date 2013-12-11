package ch.bfh.swos.flightplanning.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: AirlineEntity
 * 
 */
@Entity
public class AirlineEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true) //should be unique
	private String icao;
	private String name;
	private String countryIso;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="airline")
	private List<PlaneEntity> planes;

	public AirlineEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIcao() {
		return icao;
	}

	public void setIcao(String icao) {
		this.icao = icao;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryIso() {
		return countryIso;
	}

	public void setCountryIso(String countryIso) {
		this.countryIso = countryIso;
	}

	public List<PlaneEntity> getPlanes() {
		return planes;
	}

	public void setPlanes(List<PlaneEntity> planes) {
		this.planes = planes;
	}

}
