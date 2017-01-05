package br.router.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.router.model.ProximityEvent;
import br.router.repository.ProximityEventRepository;
import br.router.service.ProximityEventService;

@Named
public class EscapeEventServiceImpl implements ProximityEventService {

	@Inject
	private ProximityEventRepository proximityEventRepository;

	@Override
	public List<ProximityEvent> getAll() {
		return proximityEventRepository.findAll();
	}

	@Override
	public ProximityEvent save(ProximityEvent event) {
		return proximityEventRepository.save(event);
	}
	
}
