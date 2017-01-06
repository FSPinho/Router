package br.router.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import br.router.model.Route;
import br.router.model.Vehicle;

public interface RouteRepository extends MongoRepository<Route, BigInteger>{
	List<Route> findByVehicle(Vehicle vehicle);
	
	@Transactional
	Long deleteByVehicle(Vehicle vehicle);
}
