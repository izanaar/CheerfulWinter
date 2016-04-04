angular
    .module('starterApp', ['ngMaterial'])
    .config(function($mdThemingProvider) {
        $mdThemingProvider.theme('default')
            .primaryPalette('teal')
            .accentPalette('orange');
    })
    .run(function($log){
        $log.debug("starterApp + ngMaterial running...");
    });
