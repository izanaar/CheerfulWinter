angular
    .module('translateApp', [
        'ngMaterial',
        'ngRoute',
        'translateApp.translate',
        'translateApp.dictionary',
        'translateApp.review'
    ])
    .config(function ($mdThemingProvider, $routeProvider, $mdIconProvider) {
        $mdThemingProvider.theme('default')
            .primaryPalette('teal')
            .accentPalette('orange');

        $routeProvider.otherwise({redirectTo: '/dictionary'});

        $mdIconProvider.icon("dictionary", "icons/ic_repeat_black_48px.svg", 24);
        $mdIconProvider.icon("translate", "icons/ic_translate_48px.svg", 24);
        $mdIconProvider.icon("review", "icons/ic_trending_up_black_48px.svg", 24);
    })
    .run(function ($log) {
        $log.debug("starterApp + ngMaterial running...");
    });
