package ch.bfh.swos.flightplanning.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: PlaneEntity
 * 
 */
@Entity
public class PlaneEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String icao;
	private String name;
	private int seats;
	
	@ManyToOne
	private AirlineEntity airline;

	public PlaneEntity() {}

	public PlaneEntity(String icao, String name, int seats) {
		this.icao = icao;
		this.name = name;
		this.seats = seats;
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

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public AirlineEntity getAirline() {
		return airline;
	}

	public void setAirline(AirlineEntity airline) {
		this.airline = airline;
	}

}
