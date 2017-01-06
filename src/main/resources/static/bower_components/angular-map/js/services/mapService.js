var module = angular.module("angularMap");

module.factory("mapFactory", function(mapApiService, defaults) {

	var _extend = function(defOpt, opt, res, deep) {
		if(arguments.length === 2) {
			res = {};
			opt = opt || {};
			_extend(defOpt, opt, res, 10);
			return res;
		} else if(arguments.length === 4) {
			if(--deep < 0) return;
			for(k in defOpt) {
				if(opt && opt[k])
					res[k] = opt[k];
				else 
					res[k] = defOpt[k];

				if(!!res[k] && !!opt && !!defOpt)
					_extend(defOpt[k], opt[k], res[k]);
			}
		}
	}

	var _createMap = function(options) {

		options = _extend(defaults.MAP_OPTIONS, options);

		if(options.mapElement)
			return L
				.map(options.mapElement)
				.setView(
					options.center || defaults.MAP_CENTER, 
					options.zoom || defaults.MAP_ZOOM
				);

		return null;

	}

	var _createMarker = function(options) {

		options = _extend(defaults.MARKER_OPTIONS, options);
		
		var marker = L.marker(JSON.parse(JSON.stringify(options.position)), { draggable: !!options.draggable });
		if(options.info)
			marker.bindPopup(options.info);
		return marker;

	}

	var _createPolyline = function(options) {
		
		options = _extend(defaults.POLYLINE_OPTIONS, options);

		var polyline = L.polyline(options.path, {color: options.color});
		if(options.info)
			polyline.bindPopup(options.info);

		return polyline;

	}

	return {
		createMap: _createMap, 
		createMarker: _createMarker, 
		createPolyline: _createPolyline
	};

});