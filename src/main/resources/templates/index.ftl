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

<body ng-app="translateApp" layout="column">

<md-toolbar layout="row" layout-align="end center">
    <h4 flex="none" class="md-display-1" layout-margin>Translate and not forget</h4>
    <h6 flex="noshrink" class="md-body-1" layout-margin style="text-align: right">Powered by Yandex</h6>
</md-toolbar>

<div flex layout="row">
    <md-sidenav md-is-locked-open="true" class="md-whiteframe-z2">
        <md-list>
            <md-list-item>
                <md-button>
                    <md-icon md-svg-src="translate"></md-icon>
                    Translate
                </md-button>
            </md-list-item>

            <md-list-item>
                <md-button ng-href="#/dictionary">
                    <md-icon md-svg-src="dictionary"></md-icon>
                    Dictionary
                </md-button>
            </md-list-item>

            <md-list-item>
                <md-button ng-href="#/review">
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
