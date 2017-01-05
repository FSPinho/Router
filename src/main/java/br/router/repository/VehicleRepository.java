package br.router.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.router.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

}
