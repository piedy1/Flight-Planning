package ch.bfh.swos.flightplanning.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Flight
 *
 */
@Entity
public class FlightEntity implements Serializable {

	public enum FlightStatus {
		ON_TIME, DELAYED, CANCELED;
	}
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String flightNumber;
	@Temporal(TemporalType.TIMESTAMP)
	private Date departureDateAndTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date arrivalDateAndTime;
	private FlightStatus flightStatus;
	private AirportEntity flightFromAirport;
	private AirportEntity flightToAirport;
	@OneToOne(cascade=CascadeType.PERSIST)
	private GateEntity gate;
	@OneToOne(cascade=CascadeType.PERSIST)
	private PlaneEntity plane;
	
	
	public FlightEntity() { }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFlightNumber() {
		return flightNumber;
	}


	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	public Date getDepartureDateAndTime() {
		return departureDateAndTime;
	}


	public void setDepartureDateAndTime(Date departureDateAndTime) {
		this.departureDateAndTime = departureDateAndTime;
	}


	public Date getArrivalDateAndTime() {
		return arrivalDateAndTime;
	}


	public void setArrivalDateAndTime(Date arrivalDateAndTime) {
		this.arrivalDateAndTime = arrivalDateAndTime;
	}

	public FlightStatus getFlightStatus() {
		return flightStatus;
	}


	public void setFlightStatus(FlightStatus flightStatus) {
		this.flightStatus = flightStatus;
	}


	public AirportEntity getFlightFromAirport() {
		return flightFromAirport;
	}


	public void setFlightFromAirport(AirportEntity flightFromAirport) {
		this.flightFromAirport = flightFromAirport;
	}


	public AirportEntity getFlightToAirport() {
		return flightToAirport;
	}


	public void setFlightToAirport(AirportEntity flightToAirport) {
		this.flightToAirport = flightToAirport;
	}

	
	public GateEntity getGate() {
		return gate;
	}

	
	public void setGate(GateEntity gate) {
		this.gate = gate;
	}


	public PlaneEntity getPlane() {
		return plane;
	}


	public void setPlane(PlaneEntity plane) {
		this.plane = plane;
	}
	
	
	
}
