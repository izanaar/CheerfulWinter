'use strict';

angular.module('translateApp.review', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/review', {
            templateUrl: '/review/page_template',
            controller: 'ReviewCtrl'
        });
    }])

    .controller('ReviewCtrl', ['$scope', '$timeout', function($scope, $http) {

    }]);