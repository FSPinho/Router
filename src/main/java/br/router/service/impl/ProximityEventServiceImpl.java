package br.router.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.router.model.EscapeEvent;
import br.router.repository.EscapeEventRepository;
import br.router.service.EscapeEventService;

@Named
public class ProximityEventServiceImpl implements EscapeEventService {

	@Inject
	private EscapeEventRepository escapeEventRepository;

	@Override
	public List<EscapeEvent> getAll() {
		return escapeEventRepository.findAll();
	}

	@Override
	public EscapeEvent save(EscapeEvent event) {
		return escapeEventRepository.save(event);
	}
	
}
