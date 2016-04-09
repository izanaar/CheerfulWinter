angular
    .module('translateApp', [
        'ngMaterial',
        'ngRoute',
        'translateApp.translate',
        'translateApp.dictionary'
    ])
    .config(function ($mdThemingProvider, $routeProvider) {
        $mdThemingProvider.theme('default')
            .primaryPalette('teal')
            .accentPalette('orange');

        $routeProvider.otherwise({redirectTo: '/dictionary'});
    })
    .run(function ($log) {
        $log.debug("starterApp + ngMaterial running...");
    });
