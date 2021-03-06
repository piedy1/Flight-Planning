/**
 * 
 */
package ch.bfh.swos.flightplanning.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author rovi
 * 
 */
public class ReadIT {

	@Test
	public void testAirline()
	{
		EntityManager em = Persistence.createEntityManagerFactory("ch.bfh.swos.flightplanning.domain").createEntityManager();
		
		Query q = em.createQuery("select a from AirlineEntity a");
		@SuppressWarnings("unchecked")
		List<AirlineEntity> airlines = q.getResultList();
		Assert.assertEquals(1, airlines.size());
		AirlineEntity a = airlines.get(0);
		PlaneEntity p = a.getPlanes().get(0);
		Assert.assertEquals("hansli", p.getName());
		Assert.assertEquals(a.getName(), p.getAirline().getName());
	}
}
