package br.router.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import br.router.model.ProximityEvent;
import br.router.model.Vehicle;

public interface ProximityEventRepository extends MongoRepository<ProximityEvent, BigInteger>{
	List<ProximityEvent> findByVehicle(Vehicle vehicle);
	
	@Transactional
	Long deleteByVehicle(Vehicle vehicle);
}
