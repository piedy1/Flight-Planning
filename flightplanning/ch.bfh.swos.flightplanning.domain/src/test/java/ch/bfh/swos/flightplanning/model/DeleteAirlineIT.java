package ch.bfh.swos.flightplanning.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;

public class DeleteAirlineIT {

	@Test
	public void test() {

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.swos.flightplanning.domain").createEntityManager();

		Query q = em.createQuery("select a from AirlineEntity a");
		@SuppressWarnings("unchecked")
		List<AirlineEntity> foundAuthors = q.getResultList();
		AirlineEntity firstAuthor = foundAuthors.get(0);
		Assert.assertTrue(firstAuthor.getName().equals("OtherName"));

		// Write access needs a transaction
		em.getTransaction().begin();
		em.remove(firstAuthor);
		em.getTransaction().commit();
	}


}
