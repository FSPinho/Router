package br.router.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import br.router.model.EscapeEvent;
import br.router.model.Vehicle;

public interface EscapeEventRepository extends MongoRepository<EscapeEvent, BigInteger>{
	List<EscapeEvent> findByVehicle(Vehicle vehicle);
	
	@Transactional
	Long deleteByVehicle(Vehicle vehicle);
}
