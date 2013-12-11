package ch.bfh.swos.flightplanning.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.junit.Test;

public class CreateAirlineIT {
	
	@Test
	public void testCreatedAirline() {
		
		AirlineEntity a = new AirlineEntity();
		a.setCountryIso("CH");
		a.setIcao("blubb");
		a.setName("Swiss");
		
		PlaneEntity p1 = new PlaneEntity();
		p1.setIcao("p111");
		p1.setName("hansli");
		p1.setSeats(42);
		
		PlaneEntity p2 = new PlaneEntity();
		p2.setIcao("p222");
		p2.setName("peterli");
		p2.setSeats(13);
		
		List<PlaneEntity> planes = new ArrayList<>();
		planes.add(p1);
		planes.add(p2);
		p1.setAirline(a);
		p2.setAirline(a);
		a.setPlanes(planes);
		
		EntityManager em = Persistence.createEntityManagerFactory("ch.bfh.swos.flightplanning.domain").createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
	}

}
