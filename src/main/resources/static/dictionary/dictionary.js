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

        $scope.translation = {
            "def": [
                {
                    "text": "time",
                    "pos": "существительное",
                    "tr": [
                        {
                            "text": "время",
                            "pos": "существительное",
                            "gen": "ср"
                        },
                        {
                            "text": "час",
                            "pos": "существительное",
                            "gen": "м"
                        },
                        {
                            "text": "эпоха",
                            "pos": "существительное",
                            "gen": "ж"
                        },
                        {
                            "text": "век",
                            "pos": "существительное",
                            "gen": "м"
                        },
                        {
                            "text": "такт",
                            "pos": "существительное",
                            "gen": "м"
                        },
                        {
                            "text": "жизнь",
                            "pos": "существительное",
                            "gen": "ж"
                        }
                    ]
                },
                {
                    "text": "time",
                    "pos": "глагол",
                    "tr": [
                        {
                            "text": "приурочивать",
                            "pos": "глагол",
                            "gen": null
                        },
                        {
                            "text": "рассчитывать",
                            "pos": "глагол",
                            "gen": null
                        }
                    ]
                },
                {
                    "text": "time",
                    "pos": "прилагательное",
                    "tr": [
                        {
                            "text": "временный",
                            "pos": "прилагательное",
                            "gen": null
                        },
                        {
                            "text": "повременный",
                            "pos": "прилагательное",
                            "gen": null
                        }
                    ]
                }
            ]
        };
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