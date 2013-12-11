package ch.bfh.swos.flightplanning.service;

import java.util.Collection;

import ch.bfh.swos.flightplanning.service.dto.GateDTO;

public interface GateService {
	public GateDTO create(GateDTO plane);
	public GateDTO read(long id);
	public Collection<GateDTO> list();
	public GateDTO update(GateDTO plane);
	public void delete(GateDTO plane);
}
