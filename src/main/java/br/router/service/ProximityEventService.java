package br.router.service;

import java.util.List;

import br.router.model.ProximityEvent;

public interface ProximityEventService {

	List<ProximityEvent> getAll();
	ProximityEvent save(ProximityEvent event);
		
}
