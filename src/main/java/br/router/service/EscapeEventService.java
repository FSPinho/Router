package br.router.service;

import java.util.List;

import br.router.model.EscapeEvent;

public interface EscapeEventService {

	List<EscapeEvent> getAll();
	EscapeEvent save(EscapeEvent event);
		
}
