package br.router.service;

import java.util.List;

import br.router.model.ProximityEvent;
import br.router.model.Vehicle;

public interface ProximityEventService {

	List<ProximityEvent> getAll();
	List<ProximityEvent> getByVehicle(Vehicle vehicle);
	ProximityEvent save(ProximityEvent event);
		
}
