package ch.bfh.swos.flightplanning.repository;

import org.springframework.data.repository.CrudRepository;

import ch.bfh.swos.flightplanning.model.AirportEntity;

public interface AirportRepository extends CrudRepository<AirportEntity, Long> {

}
