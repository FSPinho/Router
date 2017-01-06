angular.module("router").service("apiService", function($http, apiValues) {


	this.getVehicles = function(callback) {
		
		$http.get(apiValues.ROOT_API_URL + "vehicle").
	    then(function(response) {
	    	if(response.status < 400 && response && response.data
	    			&& response.data.object) {
	    		callback(response.data);
	    	}
	    });
		
	}
	
	this.createRoute = function(vehicle, callback) {
		
		$http.get(apiValues.ROOT_API_URL + "route" + "/" + vehicle.id).
	    then(function(response) {
	    	if(response.status < 400 && response && response.data
	    			&& response.data.object) {
	    		callback(response.data);
	    	}
	    });
		
	}

});