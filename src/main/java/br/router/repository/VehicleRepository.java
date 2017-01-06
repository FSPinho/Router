package br.router.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.router.model.Vehicle;

public interface VehicleRepository extends MongoRepository<Vehicle, BigInteger>{

}
