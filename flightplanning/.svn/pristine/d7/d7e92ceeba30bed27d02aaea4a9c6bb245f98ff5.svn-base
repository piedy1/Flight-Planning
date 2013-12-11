package ch.bfh.swos.flightplanning.service.impl;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.bfh.swos.flightplanning.service.PlaneService;
import ch.bfh.swos.flightplanning.service.dto.PlaneDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContext.xml")
public class PlaneServiceIT {

	@Inject
	private PlaneService planeService;

	@Test
	public void test() {

		// Create
		PlaneDTO newPlane = new PlaneDTO();
		newPlane.setName("Test");
		newPlane = planeService.create(newPlane);

		// Read
		PlaneDTO readPlane = planeService.read(newPlane.getId());
		Assert.assertTrue(newPlane.getName().equals(readPlane.getName()));

		// Update
		readPlane.setName("Test2");
		readPlane = planeService.update(readPlane);
		PlaneDTO updatedPlane = planeService.read(readPlane.getId());
		Assert.assertTrue(readPlane.getName().equals(updatedPlane.getName()));

		// Delete
		planeService.delete(updatedPlane);
		PlaneDTO deletedPlane = planeService.read(readPlane.getId());
		Assert.assertNull(deletedPlane);
	}

}
