'use strict';

angular.module('translateApp.dictionary', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/dictionary', {
            templateUrl: '/dictionary/template',
            controller: 'DictionaryCtrl'
        });
    }])

    .controller('DictionaryCtrl', ['$scope', 'TranslateService', function ($scope, TranslateService) {
        $scope.loadSrcLangs = function () {
            TranslateService.getSourceLangs().then(function (response) {
                $scope.srcLangs = response.data;
                if(response.data.includes('en')){
                    $scope.srcLang = 'en';
                }
            });
        };

        $scope.loadTrnLangs = function () {
            TranslateService.getTranslationLagns($scope.srcLang).then(function (response) {
                $scope.trnLangs = response.data;
                if(response.data.includes('ru')){
                    $scope.trnLang = 'ru';
                }
            });
        };

        $scope.translate = function () {
            TranslateService.lookup($scope.sourceText, $scope.srcLang, $scope.trnLang)
                .then(function (response) {
                    $scope.translation = response.data;
                }, function () {
                    alert("translation failure");
                })
        };

        $scope.trnLang = null;
        $scope.srcLang = null;

        $scope.translation = null;
    }])

    .service('TranslateService', ['$http', function ($http) {
        this.getSourceLangs = function () {
            return $http.get("/dictionary/src_langs");
        };

        this.getTranslationLagns = function (sourceLang) {
            return $http.get("/dictionary/trn_langs", {
                params: {
                    src: sourceLang
                }
            });
        };

        this.lookup = function (text, srcLang, trnLang) {
            return $http.get("/dictionary/lookup", {
                params: {
                    text: text,
                    src: srcLang,
                    dst: trnLang
                }
            });
        };
    }]);