package ch.bfh.swos.flightplanning.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.modelmapper.ModelMapper;

import ch.bfh.swos.flightplanning.model.PlaneEntity;
import ch.bfh.swos.flightplanning.repository.PlaneRepository;
import ch.bfh.swos.flightplanning.service.PlaneService;
import ch.bfh.swos.flightplanning.service.dto.PlaneDTO;

public class DefaultPlaneService implements PlaneService {
	@Inject
	private PlaneRepository repository;
	
	private final ModelMapper mapper = new ModelMapper();

	@Override
	public PlaneDTO create(PlaneDTO plane) {
		PlaneEntity entity = mapper.map(plane, PlaneEntity.class);
		repository.save(entity);
		mapper.map(entity, plane);
		return plane;
	}

	@Override
	public PlaneDTO read(long id) {
		PlaneEntity entity = repository.findOne(id);
		if (entity != null) {
			return mapper.map(entity, PlaneDTO.class);
		}
		return null;
	}

	@Override
	public Collection<PlaneDTO> list() {
		List<PlaneDTO> planeDtos = new ArrayList<>();
		Iterable<PlaneEntity> planes = repository.findAll();
		for (PlaneEntity plane : planes) {
			PlaneDTO p = mapper.map(plane, PlaneDTO.class);
			planeDtos.add(p);
		}
		return planeDtos;
	}

	@Override
	public PlaneDTO update(PlaneDTO plane) {
		PlaneEntity entity = repository.findOne(plane.getId());
		if (entity != null) {
			mapper.map(plane, entity);
			repository.save(entity);
			mapper.map(entity, plane);
			return plane;
		}
		return null;
	}

	@Override
	public void delete(PlaneDTO plane) {
		repository.delete(plane.getId());
	}

}
