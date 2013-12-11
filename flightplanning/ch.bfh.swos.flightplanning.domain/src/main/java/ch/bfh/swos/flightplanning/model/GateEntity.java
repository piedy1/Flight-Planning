package ch.bfh.swos.flightplanning.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: GateEntity
 *
 */
@Entity
public class GateEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String number;
	@OneToOne(mappedBy="gate", cascade=CascadeType.PERSIST)
    private FlightEntity flight;

	public GateEntity() {}

	public GateEntity(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public FlightEntity getFlight() {
		return flight;
	}

	public void setFlight(FlightEntity flight) {
		this.flight = flight;
	}   
	
}
