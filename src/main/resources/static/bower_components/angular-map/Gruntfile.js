module.exports = function( grunt ) {
 
	grunt.initConfig({
		uglify : {
			options : {
				mangle : false
			},

			target : {
				files : {
					'angularMap.js' : [
						'js/angularMap.js',
						'js/services/mapService.js', 
						'js/services/mapApiService.js', 
						'js/value/defaults.js', 
						'js/value/providers.js', 
						'js/directives/mapDirective.js', 
						'js/directives/markerDirective.js', 
						'js/directives/polylineDirective.js', 
					]
				}
			}
		}, 

		watch : {
	      dist : {
	        files : [
	          'js/**/*'
	        ],

	        tasks : [ 'default' ]
	      }
	    }, // watch

	    karma: {
			unit: {
				configFile: 'karma.conf.js'
			}
		}

	});

	// Plugins do Grunt
	grunt.loadNpmTasks( 'grunt-contrib-uglify' );
	grunt.loadNpmTasks( 'grunt-contrib-watch' );
	grunt.loadNpmTasks( 'grunt-karma' );


	// Tarefas que serão executadas
	grunt.registerTask( 'default', [ 'uglify', 'karma' ] );

	// Tarefa para Watch
  	grunt.registerTask( 'w', [ 'watch' ] );


};