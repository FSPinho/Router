angular.module("angularMap").directive("map", function(mapFactory) {

	return {
		template: '<div ng-transclude></div>', 
		replace: true, 
		restrict: "AE",
		transclude: true, 
		
		scope: {
			tileLayer: "=", 
			center: "=", 
			zoom: "="
		}, 

		controller: function($scope) {

			$scope.listeners = [];
			this.getMap = function(callback) {
				
				if($scope.map)
					callback($scope.map);
				else
					$scope.listeners.push(callback);
				
			};
			
			$scope.$watch('tileLayer', function (old, newest) {
				old.remove();
				$scope.tileLayer.addTo($scope.map);
			});
			
		},
		
		link: function(scope, element, attrs, controller, transcludeFn) {

			console.log("MAP");

			scope.map = mapFactory.createMap({
				mapElement: element[0], 
				center: scope.center, 
				zoom: scope.zoom
			});

			scope.tileLayer.addTo(scope.map);

			scope.listeners.map(function(l) {
				l(scope.map);
			});

		} 
	};

});