angular.module("router").controller("mainController", function($scope, $mdDialog, $mdToast, apiService, mapApiService, layerProviders) {

    $scope.layers = [ 
        { name: "Google Maps", layer: mapApiService.getLayer(layerProviders.GOOGLE) }, 
        { name: "OpenStreetMap", layer: mapApiService.getLayer(layerProviders.OPEN_STREET_MAP) }, 
        { name: "openStreetMap.BlackAndWhite", layer: mapApiService.getLayer(layerProviders.OPEN_STREET_MAP_BACK_AND_WHITE) }
    ];

    $scope.tileLayer = $scope.layers[0];

    $scope.markers = [];

    $scope.path = [];

    $scope.updateVehicles = function() {
    	apiService.getVehicles(function(apiResponse) {
        	$scope.vehicles = apiResponse.object;
        });
    }
    $scope.updateVehicles();
    
    $scope.createRouteTo = function(vehicle) {
    	
	    var confirm = $mdDialog.prompt()
			.title('Paradas da rota')
			.textContent('Digite as paras separadas por vírgula')
			.placeholder('Ex.: Fortaleza, Madalena, Boa Viagem, etc...')
			.ariaLabel('Paradas')
			.initialValue('')
			.ok('OK!')
			.cancel('Cancelar');

			$mdDialog.show(confirm).then(function(result) {
				if(result) {
					var stops = result.split(/\s*,\s*/);
					stops = stops.map(function(s) {
						return {
							name: s.replace(/\s+/g, "+"), 
							position: {latitude:null, longitude:null}
						};
					});
					apiService.createRoute(vehicle, stops, function(apiResponse) {
						
					});
				}
			}, function() {}
		);
    }
    
    $scope.showRouteTo = function(vehicle) {
    	apiService.getRoute(vehicle, function(apiResponse) {
    		var route = apiResponse.object;
    		if(route.length >= 1) {
    			route = route[0];
    			$scope.routeName = route.name;
    			$scope.markers = route.stops.map(function(s) {
    				return {
    					info: s.name, 
    					draggable: false, 
    					position: [s.position.latitude, s.position.longitude]
    				};
    			});
    			$scope.path = route.path.map(function(p) {
    				return [p.latitude, p.longitude];
    			});
    		}
    	})
    }
    
    $scope.showProximityTo = function(vehicle) {
    	
	    var confirm = $mdDialog.prompt()
			.title('Próxima parada')
			.textContent(
					'Digite as coordenadas do veículo. Ex.:' +
					'Fortaleza: -3.7318595,-38.5266697, ' + 
					'Madalena: -4.852037,-39.5746425, ' + 
					'Jaguaribe: -5.8927545,-38.6219824'
			)
			.placeholder('Ex.: -4.852037,-39.5746425')
			.ariaLabel('Coordenadas')
			.initialValue('')
			.ok('OK!')
			.cancel('Cancelar');

			$mdDialog.show(confirm).then(function(result) {
				if(result) {
					var choords = result.replace(/\s+/g, "").split(/\s*,\s*/);
					choords = { latitude: parseFloat(choords[0]), longitude: parseFloat(choords[1])};
					apiService.getProximity(vehicle, choords, function(apiResponse) {
						
					});
				}
			}, function() {}
		);
    }
    
    $scope.showEscapeTo = function(vehicle) {
    	
	    var confirm = $mdDialog.prompt()
			.title('Fuga e rota')
			.textContent(
					'Digite as coordenadas do veículo. Ex.:' +
					'Fortaleza: -3.7318595,-38.5266697, ' + 
					'Madalena: -4.852037,-39.5746425, ' + 
					'Jaguaribe: -5.8927545,-38.6219824'
			)
			.placeholder('Ex.: -4.852037,-39.5746425')
			.ariaLabel('Coordenadas')
			.initialValue('')
			.ok('OK!')
			.cancel('Cancelar');

			$mdDialog.show(confirm).then(function(result) {
				if(result) {
					var choords = result.replace(/\s+/g, "").split(/\s*,\s*/);
					choords = { latitude: parseFloat(choords[0]), longitude: parseFloat(choords[1])};
					apiService.getEscape(vehicle, choords, function(apiResponse) {
						
					});
				}
			}, function() {}
		);
    }
    
});