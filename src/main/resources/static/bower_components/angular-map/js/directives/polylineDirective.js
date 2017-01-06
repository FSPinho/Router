angular.module("angularMap").directive("polyline", function(mapFactory) {

	return {
		template: "", 
		replace: true, 
		restrict: "AE",
		transclude: false, 

		scope: {
			path: "=", 
			color: "="
		}, 
		controller: function($scope) {

			$scope.$watch('path', function() {
				$scope.polyline.setLatLngs($scope.path);
			}, true);

			$scope.$on('$destroy', function() {
		        $scope.map.removeLayer($scope.polyline)
		    });

		}, 
		require: "^map", 
		link: function(scope, element, attrs, controller, transcludeFn) {

			console.log("Polly");
			controller.getMap(function(map) {
				scope.map = map;

				scope.polyline = mapFactory.createPolyline(scope);
				scope.polyline.addTo(scope.map);
			});
			
			
		} 
	};

});