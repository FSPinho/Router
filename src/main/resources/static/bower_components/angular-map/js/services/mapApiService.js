var module = angular.module("angularMap");

module.service("mapApiService", function(layerProviders) {


	this.getLayer = function(provider) {
		if(provider.startsWith(layerProviders.GOOGLE)) {
			return L.gridLayer.googleMutant();
		} else {
			return L.tileLayer.provider(provider);
		}
	}

});