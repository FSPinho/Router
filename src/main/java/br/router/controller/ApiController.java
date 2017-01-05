package br.router.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.router.maps.api.DirectionsApi;
import br.router.model.EscapeEvent;
import br.router.model.Position;
import br.router.model.ProximityEvent;
import br.router.model.Route;
import br.router.model.Stop;
import br.router.model.Vehicle;
import br.router.service.EscapeEventService;
import br.router.service.ProximityEventService;
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
	
	@Inject
	private ProximityEventService proximityEventService;
	
	@Inject
	private EscapeEventService escapeEventService;
	
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
	public ApiResponse routeCreate(@PathVariable Long vehicleId, @RequestBody Route route) {
		
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
	
	
	/*
	 * Event API
	 * */
	
	@GetMapping(value = "/proximity_event")
	public ApiResponse proximityEventGetAll() {
		return new ApiResponse()
				.withShortSuccessMessage("Router API")
				.withObject(proximityEventService.getAll());
	}
	
	@PostMapping(value = "/proximity_event/{vehicleId}")
	public ApiResponse proximityEventCreate(@PathVariable Long vehicleId, @RequestBody Position position) {
		
		Vehicle vehicle = vehicleService.getById(vehicleId);
		
		if(vehicle == null) {
			return new ApiResponse()
					.withFailStatus()
					.withShortErrorMessage("Erro ao criar evento: um veículo deve ser informado!");
		} else {
			
			List<Route> routes = routeService.getByVehicle(vehicle);
			
			if(routes.size() > 0) {
				
				Route route = routes.get(0);
				ProximityEvent event = new ProximityEvent();
				Stop stop = route.getNearStop(position);
				event.setTimestamp(System.currentTimeMillis());
				event.setMessage("A parada mais proxima é o item com o id: " + stop.getName());
				event.setVehicle(route.getVehicle());
				
				proximityEventService.save(event);
				
				return new ApiResponse()
						.withShortSuccessMessage("Evento criado!")
						.withObject(event);
			} else {
				return new ApiResponse()
						.withFailStatus()
						.withShortErrorMessage("Erro ao criar evento: um veículo informado não possui rotas!");
			}
			
		}
		
	}
	
	@GetMapping(value = "/escape_event")
	public ApiResponse escapeEventGetAll() {
		return new ApiResponse()
				.withShortSuccessMessage("Router API")
				.withObject(escapeEventService.getAll());
	}
	
	@PostMapping(value = "/escape_event/{vehicleId}")
	public ApiResponse escapeEventCreate(@PathVariable Long vehicleId, @RequestBody Position position) {
		
		Vehicle vehicle = vehicleService.getById(vehicleId);
		
		if(vehicle == null) {
			return new ApiResponse()
					.withFailStatus()
					.withShortErrorMessage("Erro ao criar evento: um veículo deve ser informado!");
		} else {
			
			List<Route> routes = routeService.getByVehicle(vehicle);
			
			if(routes.size() > 0) {
				
				Route route = routes.get(0);
				EscapeEvent event = new EscapeEvent();
				double distance = route.getRouteDistance(position);
				event.setTimestamp(System.currentTimeMillis());
				event.setMessage("O veiculo está a " + String.format("%.2f", distance) + " metros da rota");
				event.setVehicle(route.getVehicle());
				
				escapeEventService.save(event);
				
				return new ApiResponse()
						.withShortSuccessMessage("Evento criado!")
						.withObject(event);
			} else {
				return new ApiResponse()
						.withFailStatus()
						.withShortErrorMessage("Erro ao criar evento: um veículo informado não possui rotas!");
			}
			
		}
		
	}
	
}
