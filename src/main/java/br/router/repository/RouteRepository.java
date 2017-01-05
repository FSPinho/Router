package br.router.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.router.model.Route;
import br.router.model.Vehicle;

public interface RouteRepository extends JpaRepository<Route, Long>{
	List<Route> findByVehicle(Vehicle vehicle);
	
	@Transactional
	Long deleteByVehicle(Vehicle vehicle);
}
