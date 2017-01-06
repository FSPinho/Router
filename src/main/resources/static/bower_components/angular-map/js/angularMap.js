
(function(root, factory) {

	if (typeof define === "function" && define.amd) {

		define("angular-map", ["angular"], factory);

	} else if (typeof exports === "object") {
		
		module.exports = factory(require("angular"));

	} else {
		
		factory(angular);

	}

})(this, function(angular) {

	angular.module("angularMap", []);

});