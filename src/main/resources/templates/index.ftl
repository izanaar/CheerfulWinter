<!DOCTYPE html>
<html lang="en">
<head>
    <title>Translate</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1"/>

<#include "commonDependencies.ftl">

    <link rel='stylesheet' href='bower_components/roboto-fontface/css/roboto-fontface.css'>
    <link rel="stylesheet" href="bower_components/angular-material/angular-material.css"/>
    <link rel="stylesheet" href="app.css"/>

</head>

<body ng-app="translateApp" layout="column" ng-controller="IndexCtrl">

<md-toolbar layout="row" layout-align="start center">
    <md-button ng-click="openMenu()" class="md-icon-button md-primary" aria-label="Menu" hide-gt-md>
        <md-icon md-svg-src="/icons/ic_menu_48px.svg" style="color:white"></md-icon>
    </md-button>
    <h4 flex="none" class="md-display-1" layout-margin>
        Dictionary
    </h4>
</md-toolbar>

<div flex layout="row">
    <md-sidenav md-is-locked-open="$mdMedia('gt-md')"
                md-component-id="menu"
                class="md-whiteframe-z2">
        <md-list>
            <md-list-item>
                <md-button
                        ng-click="closeMenu()">
                    <md-icon md-svg-src="translate"></md-icon>
                    Translate
                </md-button>
            </md-list-item>

            <md-list-item>
                <md-button href="#/dictionary"
                           ng-click="closeMenu()">
                    <md-icon md-svg-src="dictionary"></md-icon>
                    Dictionary
                </md-button>
            </md-list-item>

            <md-list-item>
                <md-button ng-href="#/review"
                           ng-click="closeMenu()">
                    <md-icon md-svg-src="review"></md-icon>
                    Review
                </md-button>
            </md-list-item>

        </md-list>
    </md-sidenav>

    <md-content flex ng-view class="bkgrnd">

    </md-content>

</div>
</body>
</html>
