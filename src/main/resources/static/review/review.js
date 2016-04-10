'use strict';

angular.module('translateApp.review', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/review', {
            templateUrl: '/review/page_template',
            controller: 'ReviewCtrl'
        });
    }])

    .controller('ReviewCtrl', ['$scope', 'ReviewService', function ($scope, ReviewService) {
        ReviewService.getTranslations().then(function (response) {
            $scope.translations = response.data;
        }, function () {
            alert('Translations loading failed.');
        })
    }])

    .service('ReviewService', ['$http', function ($http) {
        this.getTranslations = function () {
            return $http.get('/review/translations');
        }
    }]);