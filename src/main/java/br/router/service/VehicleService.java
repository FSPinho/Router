package br.router.service;

import java.math.BigInteger;
import java.util.List;

import br.router.model.Vehicle;

public interface VehicleService {

	Vehicle getById(BigInteger id);
	List<Vehicle> getAll();
	Vehicle save(Vehicle vehicle);
		
}
