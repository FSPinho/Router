angular.module("angularMap").value("defaults", {
	MAP_OPTIONS: {
		mapElement: null,
		center: [-5.3062885, -39.3806493], 
		zoom: 4
	}, 
	MARKER_OPTIONS: {
		position: [-5.3062885, -39.3806493], 
		info: null, 
		draggable: false
	}, 
	POLYLINE_OPTIONS: {
		path: [[-5.3062885, -39.3806493], [-6.3062885, -40.3806493]], 
		color: "#9C27B0"
	}
});