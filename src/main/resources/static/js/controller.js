angular.module("router").controller("mainController", function($scope, apiService, mapApiService, layerProviders) {

    $scope.layers = [ 
        { name: "Google Maps", layer: mapApiService.getLayer(layerProviders.GOOGLE) }, 
        { name: "OpenStreetMap", layer: mapApiService.getLayer(layerProviders.OPEN_STREET_MAP) }, 
        { name: "openStreetMap.BlackAndWhite", layer: mapApiService.getLayer(layerProviders.OPEN_STREET_MAP_BACK_AND_WHITE) }
    ];

    $scope.tileLayer = $scope.layers[0];

    $scope.markers = [
        { position: [-5.3062885 - 3, -39.3806493 + 2], info: "Marker info 1", draggable: true }, 
        { position: [-5.3062885 + 3, -39.3806493 + 3], info: "Marker info 2", draggable: true }, 
        { position: [-5.3062885 - 2, -39.3806493 - 2], info: "Marker info 3", draggable: true }, 
        { position: [-5.3062885 + 2, -39.3806493 - 3], info: "Marker info 4", draggable: true }
    ];

    $scope.path = $scope.markers.map(function(m) {
        return m.position;
    });

    $scope.updateVehicles = function() {
    	apiService.getVehicles(function(apiResponse) {
        	$scope.vehicles = apiResponse.object;
        });
    }
    
    $scope.createRouteTo = function(vehicle) {
    	
    }
    
});