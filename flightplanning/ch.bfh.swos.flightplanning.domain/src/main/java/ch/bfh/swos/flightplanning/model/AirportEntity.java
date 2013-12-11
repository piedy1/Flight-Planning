package ch.bfh.swos.flightplanning.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: AirportEntity
 *
 */

@Entity
public class AirportEntity implements Serializable {
	
	public AirportEntity(){}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true) //should be unique
	private String icao;
	private String name;

	@OneToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private List<AirlineEntity> airlines;
	@OneToMany(cascade={CascadeType.ALL})
	private List<GateEntity> gates;
	@OneToMany(cascade={CascadeType.ALL})
	private List<FlightEntity> flights;

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

	public List<AirlineEntity> getAirlines() {
		return airlines;
	}

	public void setAirlines(List<AirlineEntity> airlines) {
		this.airlines = airlines;
	}

	public List<GateEntity> getGates() {
		return gates;
	}

	public void setGates(List<GateEntity> gates) {
		this.gates = gates;
	}

	public List<FlightEntity> getFlights() {
		return flights;
	}

	public void setFlights(List<FlightEntity> flights) {
		this.flights = flights;
	}
   
}
