package br.router.service.impl;

import java.math.BigInteger;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.router.model.Vehicle;
import br.router.repository.VehicleRepository;
import br.router.service.VehicleService;

@Named
public class VehicleServiceImpl implements VehicleService {

	@Inject
	private VehicleRepository vehicleRepository;

	@Override
	public Vehicle getById(BigInteger id) {
		return vehicleRepository.findOne(id);
	}
	
	@Override
	public List<Vehicle> getAll() {
		return vehicleRepository.findAll();
	}
	
	@Override
	public Vehicle save(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

}
