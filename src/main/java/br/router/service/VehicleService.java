package br.router.service;

import java.util.List;

import br.router.model.Vehicle;

public interface VehicleService {

	Vehicle getById(Long id);
	List<Vehicle> getAll();
	Vehicle save(Vehicle vehicle);
		
}
