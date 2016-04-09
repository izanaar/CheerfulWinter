<div layout="row">

    <div flex="50" class="md-whiteframe-2dp panel">
        <div layout="row">
            <md-input-container class="input-container-flat" flex="noshrink" layout="row">
                <md-select placeholder="Source language" ng-model="srcLang" md-on-open="loadSrcLangs()">
                    <md-option ng-value="srcLang" ng-repeat="srcLang in srcLangs">{{srcLang}}</md-option>
                </md-select>
            </md-input-container>
            <md-input-container class="input-container-flat" flex="noshrink" layout="row">
                <md-select placeholder="Translation language" ng-model="trnLang" md-on-open="loadTrnLangs()">
                    <md-option ng-value="trnLang" ng-repeat="trnLang in trnLangs">{{trnLang}}</md-option>
                </md-select>
            </md-input-container>
            <md-input-container class="input-container-flat" flex="none">
                <md-button class="md-raised md-primary" ng-click="translate()">
                    Translate
                </md-button>
            </md-input-container>
        </div>
        <div>
            <div flex>
                <md-input-container class="md-block">
                    <textarea ng-model="sourceText" md-maxlength="150" rows="5" md-select-on-focus=""></textarea>
                </md-input-container>
            </div>
        </div>
    </div>

    <div flex="50" layout-padding class="md-whiteframe-2dp panel" layout="column">

        <div layout="column" ng-repeat="definition in translation.def">
            <div>{{$index + 1}} {{definition.text}} {{definition.pos}}:</div>
            <div flex-offset="5" ng-repeat="translation in definition.tr">
                {{translation.text}} <span ng-show="translation.gen !== null">({{translation.gen}})
            </span>
            </div>
        </div>

    </div>
</div>