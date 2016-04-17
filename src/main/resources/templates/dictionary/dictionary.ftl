<div layout-gt-sm="row" layout="column">

    <div flex="50" class="md-whiteframe-2dp panel">
        <div layout="row">
            <md-input-container class="input-container-flat" flex="40" layout="row">
                <md-select placeholder="from" ng-model="srcLang" md-on-open="loadSrcLangs()">
                    <md-option ng-value="srcLang" ng-repeat="srcLang in srcLangs | orderBy:'toString()'">{{srcLang}}</md-option>
                </md-select>
            </md-input-container>
            <md-input-container class="input-container-flat" flex="40" layout="row">
                <md-select placeholder="to" ng-model="trnLang" md-on-open="loadTrnLangs()">
                    <md-option ng-value="trnLang" ng-repeat="trnLang in trnLangs | orderBy:'toString()'">{{trnLang}}</md-option>
                </md-select>
            </md-input-container>
            <md-input-container class="input-container-flat" flex="none">
                <md-button class="md-fab md-mini md-primary" aria-label="Profile" ng-click="translate()">
                    <md-icon md-svg-src="dictionary"></md-icon>
                </md-button>
            </md-input-container>
        </div>
        <div>
            <div flex>
                <md-input-container class="md-block">
                    <textarea ng-model="sourceText" placeholder="Type word to translate..." rows="1" md-select-on-focus=""></textarea>
                </md-input-container>
            </div>
        </div>
    </div>

    <div flex="50" layout-padding class="md-whiteframe-2dp panel" layout="column">
        <div layout="column" ng-repeat="definition in translation.def">
            <div class="definition">
                <span segment="word"> {{definition.text}} </span>
                <span segment="position">{{definition.pos}}</span>:</div>
            <div class="translation" flex-offset="5" ng-repeat="translation in definition.tr">
                <span segment="text">{{translation.text}}</span>
                <span segment="gender" ng-show="translation.gen !== null">{{translation.gen}}</span>
            </div>
        </div>

    </div>
</div>