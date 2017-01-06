package br.router.service;

import java.util.List;

import br.router.model.EscapeEvent;
import br.router.model.Vehicle;

public interface EscapeEventService {

	List<EscapeEvent> getAll();
	List<EscapeEvent> getByVehicle(Vehicle vehicle);
	EscapeEvent save(EscapeEvent event);
		
}
