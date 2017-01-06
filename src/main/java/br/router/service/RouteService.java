package br.router.service;

import java.math.BigInteger;
import java.util.List;

import br.router.model.Route;
import br.router.model.Vehicle;

public interface RouteService {

	Route getById(BigInteger id);
	List<Route> getByVehicle(Vehicle vehicle);
	List<Route> getAll();
	Route save(Route route);
	void deleteByVehicle(Vehicle vehicle);
		
}
