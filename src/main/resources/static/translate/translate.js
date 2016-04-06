'use strict';

angular.module('translateApp.translate', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/translate', {
            templateUrl: '/translation/page_template',
            controller: 'TranslateCtrl'
        });
    }])

    .controller('TranslateCtrl', ['$scope', '$timeout', function($scope, $http) {
        
    }]);