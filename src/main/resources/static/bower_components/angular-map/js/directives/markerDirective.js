angular.module("angularMap").directive("marker", function(mapFactory) {

	return {
		template: "", 
		replace: true, 
		restrict: "AE",
		transclude: false, 

		scope: {
			position: "=", 
			info: "=", 
			draggable: "=", 
		}, 
		controller: function($scope) {

			$scope.$watch('position', function() {
				var latlng = { lat: parseFloat($scope.position[0]), lng: parseFloat($scope.position[1]) };
				$scope.marker.setLatLng(latlng);
			}, true);

			$scope.$on('$destroy', function() {
		        $scope.map.removeLayer($scope.marker)
		    });

		}, 
		require: "^map", 
		link: function(scope, element, attrs, controller, transcludeFn) {

			console.log("Marker");

			controller.getMap(function(map) {
				scope.map = map;

				scope.marker = mapFactory.createMarker(scope);
				scope.marker.addTo(scope.map);
				scope.marker.on("drag", function(e) {
					scope.position[0] = scope.marker.getLatLng().lat;
					scope.position[1] = scope.marker.getLatLng().lng;
					scope.$apply();
				});
			});
			

		} 
	};

});