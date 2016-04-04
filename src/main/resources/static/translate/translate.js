'use strict';

angular.module('translateApp.translate', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/translate', {
            templateUrl: '/translate',
            controller: 'TranslateCtrl'
        });
    }])

    .controller('TranslateCtrl', ['$scope', '$timeout', function($scope, $timeout) {
        $scope.label = "Source lang:";

        $scope.user = null;
        $scope.users = null;
        $scope.loadUsers = function() {
            // Use timeout to simulate a 650ms request.
            return $timeout(function() {
                $scope.users =  $scope.users  || [
                        { id: 1, name: 'Scooby Doo' },
                        { id: 2, name: 'Shaggy Rodgers' },
                        { id: 3, name: 'Fred Jones' },
                        { id: 4, name: 'Daphne Blake' },
                        { id: 5, name: 'Velma Dinkley' }
                    ];
            }, 650);
        };
    }]);