'use strict';

angular.module('translateApp.translate', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/translate', {
            templateUrl: '/translate/',
            controller: 'TranslateCtrl'
        });
    }])

    .controller('TranslateCtrl', ['$scope', '$timeout', function($scope, $http) {
        
    }]);