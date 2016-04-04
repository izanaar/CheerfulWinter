<!DOCTYPE html>
<html lang="en">
<head>
    <title>Translate</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1"/>

<#include "commonDependencies.ftl">

    <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Roboto:400,700'>
    <link rel="stylesheet" href="bower_components/angular-material/angular-material.css"/>
    <link rel="stylesheet" href="css/style.css"/>

</head>

<body ng-app="starterApp" layout="column">

<md-toolbar layout="row">
    <h2>Translate and not forget</h2>
</md-toolbar>

<div flex layout="row">
    <md-sidenav md-is-locked-open="true" class="md-whiteframe-z2">
        <md-list>
            <md-list-item>
                <md-button>
                    <md-icon md-svg-src="icons/ic_translate_48px.svg"></md-icon>
                    Translate
                </md-button>
            </md-list-item>

            <md-list-item>
                <md-button>
                    <md-icon md-svg-src="icons/ic_trending_up_black_48px.svg"></md-icon>
                    Review
                </md-button>
            </md-list-item>

        </md-list>
    </md-sidenav>

    <md-content flex layout="row" id="content" layout-wrap>

        <div flex="50">
            <md-input-container layout="row" class="md-block">
                <label>Biography</label>
                <textarea ng-model="user.biography" md-maxlength="150" rows="5" md-select-on-focus=""></textarea>
            </md-input-container>
        </div>
        <div flex="50">
            <md-input-container layout="row" class="md-block">
                <label>Biography</label>
                <textarea ng-model="user.biography" md-maxlength="150" rows="5" md-select-on-focus=""></textarea>
            </md-input-container>
        </div>


        <!--
        Copyright 2016 Google Inc. All Rights Reserved.
        Use of this source code is governed by an MIT-style license that can be in foundin the LICENSE file at http://material.angularjs.org/license.
        -->
    <#--<md-input-container layout="row" class="md-block">
        <label>Biography</label>
        <textarea ng-model="user.biography" md-maxlength="150" rows="5" md-select-on-focus=""></textarea>
    </md-input-container>
    <md-input-container class="md-block">
        <label>Biography</label>
        <textarea ng-model="user.biography" md-maxlength="150" rows="5" md-select-on-focus=""></textarea>
    </md-input-container>-->
    </md-content>

</div>
</body>
</html>
