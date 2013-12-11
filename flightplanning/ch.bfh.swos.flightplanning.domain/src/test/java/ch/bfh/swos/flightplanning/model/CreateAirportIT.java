package ch.bfh.swos.flightplanning.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Test;

import ch.bfh.swos.flightplanning.model.FlightEntity.FlightStatus;

public class CreateAirportIT {

	@Test
	public void test() {
	
		//Create Airports
		AirportEntity zurichAirp = new AirportEntity();
		zurichAirp.setIcao("Z122");
		zurichAirp.setName("Kloten");
		AirportEntity newYorkAirp = new AirportEntity();
		newYorkAirp.setIcao("NY234");
		newYorkAirp.setName("La Guardia");
		
		//Create Airline
		AirlineEntity swissAir = new AirlineEntity();
		swissAir.setCountryIso("CH");
		swissAir.setIcao("blubb");
		swissAir.setName("Swiss");
		
		PlaneEntity airbus320 = new PlaneEntity();
		airbus320.setIcao("p111");
		airbus320.setName("Airbus320");
		airbus320.setSeats(80);
		
		PlaneEntity airbus380 = new PlaneEntity();
		airbus380.setIcao("p222");
		airbus380.setName("Airbus380");
		airbus380.setSeats(120);
		
		List<PlaneEntity> planes = new ArrayList<>();
		planes.add(airbus320);
		planes.add(airbus380);
		airbus320.setAirline(swissAir);  
		airbus380.setAirline(swissAir);
		swissAir.setPlanes(planes);		
		
		//Create Gate
		GateEntity gate = new GateEntity();
		gate.setNumber("15B");		
		
		//Create a flight from zurich to new york
		FlightEntity flight = new FlightEntity();
		flight.setFlightNumber("S123");
    	flight.setPlane(airbus380);
		flight.setFlightFromAirport(zurichAirp);
		flight.setFlightToAirport(newYorkAirp);
		flight.setDepartureDateAndTime(new Date());
		flight.setArrivalDateAndTime(new Date());
		flight.setGate(gate);
		gate.setFlight(flight);
		flight.setFlightStatus(FlightStatus.ON_TIME);
		
		List<AirlineEntity> airlines = new ArrayList<>();
		airlines.add(swissAir);
		List<FlightEntity> flights = new ArrayList<>();
		flights.add(flight);
		List<GateEntity> gates = new ArrayList<>();
		gates.add(gate);
		
		zurichAirp.setAirlines(airlines);
		zurichAirp.setFlights(flights);
		zurichAirp.setGates(gates);
		
		newYorkAirp.setAirlines(airlines);
		
		EntityManager em = Persistence.createEntityManagerFactory("ch.bfh.swos.flightplanning.domain").createEntityManager();
		em.getTransaction().begin();
		em.persist(zurichAirp);
		em.persist(newYorkAirp);
		em.getTransaction().commit();
		
	}
}
