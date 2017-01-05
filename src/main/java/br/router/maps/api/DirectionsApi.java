package br.router.maps.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import br.router.maps.model.DirectionsLeg;
import br.router.maps.model.DirectionsLocation;
import br.router.maps.model.DirectionsRequest;
import br.router.maps.model.DirectionsResponse;
import br.router.maps.model.DirectionsRoute;
import br.router.maps.model.DirectionsStep;
import br.router.model.Position;
import br.router.model.Route;
import br.router.model.Stop;

public class DirectionsApi {
	
	private DirectionsApi() {
		
	}
	
	public static DirectionsResponse getDiretions(DirectionsRequest request) {
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://maps.googleapis.com/maps/api/directions/json?language=pt-BR&" + request;
		System.out.println(url);
		
	    restTemplate.setMessageConverters(Arrays.asList(new MappingJackson2HttpMessageConverter()));
	    ResponseEntity<DirectionsResponse> response = restTemplate
	    		.getForEntity(url, DirectionsResponse.class);
	    return response.getBody();
	    
	}
	
	public static void getDiretionsTo(Route route) {
		
		List<DirectionsLocation> directionsInnerPath = new ArrayList<>();
		List<Stop> innerPath = route.getInnerPath();
		
		for(Stop stop: innerPath) {
			directionsInnerPath.add(new DirectionsLocation(stop.getName(), stop.getPosition().getLatitude(), stop.getPosition().getLongitude()));
		}
		
		DirectionsLocation origin = new DirectionsLocation(
				route.getOrigin().getName(), 
				route.getOrigin().getPosition().getLatitude(), 
				route.getOrigin().getPosition().getLongitude()
		);
		
		DirectionsLocation destination = new DirectionsLocation(
				route.getDestination().getName(), 
				route.getDestination().getPosition().getLatitude(), 
				route.getDestination().getPosition().getLongitude() 
		);
		
		DirectionsRequest request = new DirectionsRequest(
			origin, 
			destination, 
			directionsInnerPath, 
			true
		);
		
		DirectionsResponse response = DirectionsApi.getDiretions(request);
		
		if(response.getRoutes().size() >= 1) {
			DirectionsRoute dRoute = response.getRoutes().get(0);
			
			if(dRoute.getLegs().size() > 0) {				
				List<Position> path = new ArrayList<>();
				for(DirectionsLeg leg: dRoute.getLegs()) {
					for(DirectionsStep step: leg.getSteps()) {
						path.add(new Position(step.getStart_location().getLat(), step.getStart_location().getLng()));
					}
					path.add(new Position(
							leg.getSteps().get(0).getEnd_location().getLat(), 
							leg.getSteps().get(leg.getSteps().size() - 1).getEnd_location().getLng())
					);
				}
				
				/* Naming */
				
				for(int i = 0; i < route.getStops().size(); i++) {
					Stop stop = route.getStops().get(i);
					
					String name = "";
					
					if(i >= dRoute.getLegs().size()) {
						name = dRoute.getLegs().get(i - 1).getEnd_address();
					} else {
						name = dRoute.getLegs().get(i).getStart_address();
					}
					stop.setName(name);
					
					Position position = stop.getPosition();
					
					if(i >= dRoute.getLegs().size()) {
						position.setLatitude(dRoute.getLegs().get(i - 1).getEnd_location().getLat());
						position.setLongitude(dRoute.getLegs().get(i - 1).getEnd_location().getLng());
					} else {
						position.setLatitude(dRoute.getLegs().get(i).getEnd_location().getLat());
						position.setLongitude(dRoute.getLegs().get(i).getEnd_location().getLng());
					}
					stop.setName(name);
				}

				route.setPath(path);
			}
		}
	    
	}
	
}
