'use strict';

angular.module('translateApp.dictionary', ['ngRoute'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/dictionary', {
            templateUrl: '/dictionary/template',
            controller: 'DictionaryCtrl'
        });
    }])

    .controller('DictionaryCtrl', ['$scope', 'TranslateService', function($scope, TranslateService) {
        $scope.loadSrcLangs = function () {
            TranslateService.getSourceLangs().then(function (response) {
                $scope.srcLangs = response.data;
            });
        };

        $scope.loadTrnLangs = function () {
            TranslateService.getTranslationLagns($scope.srcLang).then(function (response) {
                $scope.trnLangs = response.data;
            });
        };

        $scope.trnLang = null;
        $scope.srcLang = null;
    }])

    .service('TranslateService', ['$http', function ($http) {
        this.getSourceLangs = function () {
            return $http.get("/dictionary/src_langs");
        };

        this.getTranslationLagns = function (sourceLang) {
            console.log(sourceLang);
            return $http.get("/dictionary/trn_langs", {
                params: {
                    src: sourceLang
                }
            });
        }
    }]);