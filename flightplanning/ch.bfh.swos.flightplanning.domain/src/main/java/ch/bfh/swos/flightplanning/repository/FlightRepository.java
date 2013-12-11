package ch.bfh.swos.flightplanning.repository;

import org.springframework.data.repository.CrudRepository;

import ch.bfh.swos.flightplanning.model.FlightEntity;

public interface FlightRepository extends CrudRepository<FlightEntity, Long>{

}
