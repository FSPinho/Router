describe('Map Factory', function() {
	var mapFactory;

	beforeEach(angular.mock.module('angularMap'));
	beforeEach(inject(function(_mapFactory_) {
		mapFactory = _mapFactory_;
	}));

	it('Deve ser definido', function() {
		expect(mapFactory).toBeDefined();
	});

	describe('.createMap()', function() {
		it('Deve ser definido', function() {
			expect(mapFactory.createMap).toBeDefined();
		});
	});

	describe('.createMarker()', function() {
		it('Deve ser definido', function() {
			expect(mapFactory.createMarker).toBeDefined();
		});
	});

	describe('.createPolyline()', function() {
		it('Deve ser definido', function() {
			expect(mapFactory.createPolyline).toBeDefined();
		});
	});

});