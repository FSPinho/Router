package br.router.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.router.model.Route;
import br.router.model.Vehicle;
import br.router.repository.RouteRepository;
import br.router.service.RouteService;

@Named
public class RouteServiceImpl implements RouteService {

	@Inject
	private RouteRepository routeRepository;

	@Override
	public Route getById(Long id) {
		return routeRepository.findOne(id);
	}

	@Override
	public List<Route> getByVehicle(Vehicle vehicle) {
		return routeRepository.findByVehicle(vehicle);
	}

	@Override
	public List<Route> getAll() {
		return routeRepository.findAll();
	}

	@Override
	public Route save(Route route) {
		return routeRepository.save(route);
	}
	
	@Override
	public void deleteByVehicle(Vehicle vehicle) {
		routeRepository.deleteByVehicle(vehicle);
	}

}
