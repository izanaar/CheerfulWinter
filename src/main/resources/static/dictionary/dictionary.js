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
            });
        };

        $scope.loadTrnLangs = function () {
            TranslateService.getTranslationLagns($scope.srcLang).then(function (response) {
                $scope.trnLangs = response.data;
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

        $scope.translation = {"def":[{"text":"test","pos":"существительное","tr":[{"text":"испытание","pos":"существительное","gen":"ср"},{"text":"анализ","pos":"существительное","gen":"м"},{"text":"критерий","pos":"существительное","gen":"м"},{"text":"опыт","pos":"существительное","gen":"м"},{"text":"контрольная работа","pos":"существительное","gen":null},{"text":"реактив","pos":"существительное","gen":"м"}]},{"text":"test","pos":"прилагательное","tr":[{"text":"испытательный","pos":"прилагательное","gen":null}]},{"text":"test","pos":"глагол","tr":[{"text":"тестировать","pos":"глагол","gen":null},{"text":"испытывать","pos":"глагол","gen":null}]}]};
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