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
public class UpdateIT {

	@Test
	public void test() {

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.swos.flightplanning.domain").createEntityManager();

		Query q = em.createQuery("select a from AirlineEntity a");
		@SuppressWarnings("unchecked")
		List<AirlineEntity> foundAuthors = q.getResultList();
		AirlineEntity firstAuthor = foundAuthors.get(0);

		// Write access needs a transaction
		em.getTransaction().begin();
		firstAuthor.setName("OtherName");
		em.getTransaction().commit();
		// Entity is persisted automatically after commit because it is managed
		// by jpa.

		Assert.assertTrue(firstAuthor.getName().equals("OtherName"));
	}

}
