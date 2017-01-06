package br.router.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.router.model.ProximityEvent;
import br.router.model.Vehicle;

public interface ProximityEventRepository extends JpaRepository<ProximityEvent, Long>{
	List<ProximityEvent> findByVehicle(Vehicle vehicle);
	
	@Transactional
	Long deleteByVehicle(Vehicle vehicle);
}
