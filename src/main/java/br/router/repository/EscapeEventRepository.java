package br.router.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.router.model.EscapeEvent;
import br.router.model.Vehicle;

public interface EscapeEventRepository extends JpaRepository<EscapeEvent, Long>{
	List<EscapeEvent> findByVehicle(Vehicle vehicle);
	
	@Transactional
	Long deleteByVehicle(Vehicle vehicle);
}
