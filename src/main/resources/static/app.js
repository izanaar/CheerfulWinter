angular
    .module('translateApp', [
        'ngMaterial',
        'ngRoute',
        'translateApp.translate'
    ])
    .config(function ($mdThemingProvider, $routeProvider) {
        $mdThemingProvider.theme('default')
            .primaryPalette('teal')
            .accentPalette('orange');

        $routeProvider.otherwise({redirectTo: '/translate'});
    })
    .run(function ($log) {
        $log.debug("starterApp + ngMaterial running...");
    });
