package br.router.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.router.maps.api.DirectionsApi;
import br.router.model.Route;
import br.router.model.Vehicle;
import br.router.service.RouteService;
import br.router.service.VehicleService;
import br.router.util.api.ApiResponse;

@RestController
@RequestMapping("api")
public class ApiController {
	
	@Inject
	private VehicleService vehicleService;
	
	@Inject
	private RouteService routeService;
	
	/*
	 * Root API
	 * */
	
	@GetMapping(value = "")
	public ApiResponse root() {
		return new ApiResponse()
				.withShortSuccessMessage("Router API");
	}
	
	/*
	 * Vehicle API
	 * */
	
	@GetMapping(value = "/vehicle")
	public ApiResponse vehicleGetAll() {
		return new ApiResponse()
				.withShortSuccessMessage("Router API")
				.withObject(vehicleService.getAll());
	}
		
	
	/*
	 * Route API
	 * */
	
	@GetMapping(value = "/route")
	public ApiResponse routeGetAll() {
		return new ApiResponse()
				.withShortSuccessMessage("Router API")
				.withObject(routeService.getAll());
	}
	
	@PostMapping(value = "/route/{vehicleId}")
	public ApiResponse vehicleAddRoute(@PathVariable Long vehicleId, @RequestBody Route route) {
		
		Vehicle vehicle = vehicleService.getById(vehicleId);
		
		if(vehicle == null) {
			return new ApiResponse()
					.withFailStatus()
					.withShortErrorMessage("Erro ao criar rota: um veículo deve ser informado!");
		} else if(route.isValid()) {
			routeService.deleteByVehicle(vehicle);
			route.setVehicle(vehicle);
			route.setTimestamp(System.currentTimeMillis());
			DirectionsApi.getDiretionsTo(route);
			routeService.save(route);
			
			return new ApiResponse()
					.withObject(route)
					.withShortSuccessMessage("Rota criada!");
		} else {
			return new ApiResponse()
					.withFailStatus()
					.withShortErrorMessage("Erro ao criar rota: as paradas são inválidas!"); 
		}
				
	}
	
}
