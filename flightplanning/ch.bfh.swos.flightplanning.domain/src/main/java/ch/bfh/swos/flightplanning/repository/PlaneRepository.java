package ch.bfh.swos.flightplanning.repository;

import org.springframework.data.repository.CrudRepository;

import ch.bfh.swos.flightplanning.model.PlaneEntity;

public interface PlaneRepository extends CrudRepository<PlaneEntity, Long> {

}
