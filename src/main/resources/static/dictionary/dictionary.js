'use strict';

angular.module('translateApp.dictionary', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/dictionary', {
            templateUrl: '/dictionary/template',
            controller: 'DictionaryCtrl'
        });
    }])

    .controller('DictionaryCtrl', ['$scope', '$timeout', function($scope, $http) {
        $scope.testVal = 'Tempest keep was merely a setback.'
    }]);