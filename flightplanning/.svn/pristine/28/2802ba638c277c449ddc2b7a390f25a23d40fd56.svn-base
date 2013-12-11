package ch.bfh.swos.flightplanning.repository;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.bfh.swos.flightplanning.model.PlaneEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/persistenceContext.xml")
public class PlaneRepositoryIT {
	@Inject
	private PlaneRepository repository;

	@Test
	public void test() {
		// create
		PlaneEntity plane = new PlaneEntity();
		plane.setName("test");
		repository.save(plane);

		// read
		PlaneEntity readPlane = repository.findOne(plane.getId());
		Assert.assertTrue(plane.getName().equals(readPlane.getName()));
		
		// update
		readPlane.setName("test2");
		readPlane = repository.save(readPlane);
		PlaneEntity updated = repository.findOne(readPlane.getId());
		Assert.assertTrue(readPlane.getName().equals(updated.getName()));
		
		// delete
		repository.delete(updated);
		PlaneEntity deleted = repository.findOne(readPlane.getId());
		Assert.assertNull(deleted);
	}
}
