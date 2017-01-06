angular.module("router").service("apiService", function($http,$mdToast, apiValues) {

	var _bigIntegerToString = function(x) {
	  if (Math.abs(x) < 1.0) {
	    var e = parseInt(x.toString().split('e-')[1]);
	    if (e) {
	        x *= Math.pow(10,e-1);
	        x = '0.' + (new Array(e)).join('0') + x.toString().substring(2);
	    }
	  } else {
	    var e = parseInt(x.toString().split('+')[1]);
	    if (e > 20) {
	        e -= 20;
	        x /= Math.pow(10,e);
	        x += (new Array(e+1)).join('0');
	    }
	  }
	  return x;
	}
	
	var _alert = function(a) {
		if(a) 
			$mdToast.show(
		      $mdToast.simple()
		        .textContent(a.text)
		        .hideDelay(a.delay)
		    );
	}

	this.getVehicles = function(callback) {
		
		$http.get(apiValues.ROOT_API_URL + "vehicle").
	    then(function(response) {
	    	if(response.status < 400 && response && response.data) {
	    		callback(response.data);
	    		_alert(response.data.alert);
	    	}
	    });
		
	}
	
	this.createRoute = function(vehicle, stops, callback) {
		var route = {
				name: "", 
				stops: stops
		}
		$http.post(apiValues.ROOT_API_URL + "route/" + _bigIntegerToString(vehicle.id), route).
	    then(function(response) {
	    	if(response.status < 400 && response && response.data) {
	    		callback(response.data);
	    		_alert(response.data.alert);
	    	}
	    });
		
	}
	
	this.getRoute = function(vehicle, callback) {
		$http.get(apiValues.ROOT_API_URL + "route/by_vehicle/" + _bigIntegerToString(vehicle.id)).
	    then(function(response) {
	    	if(response.status < 400 && response && response.data) {
	    		callback(response.data);
	    		_alert(response.data.alert);
	    	}
	    });
	}
	
	this.getProximity = function(vehicle, position, callback) {
		$http.post(apiValues.ROOT_API_URL + "proximity_event/" + _bigIntegerToString(vehicle.id), position).
	    then(function(response) {
	    	if(response.status < 400 && response && response.data) {
	    		callback(response.data);
	    		_alert(response.data.alert);
	    	}
	    });
	}
	
	this.getEscape = function(vehicle, position, callback) {
		$http.post(apiValues.ROOT_API_URL + "escape_event/" + _bigIntegerToString(vehicle.id), position).
	    then(function(response) {
	    	if(response.status < 400 && response && response.data) {
	    		callback(response.data);
	    		_alert(response.data.alert);
	    		
	    	}
	    });
	}

});






