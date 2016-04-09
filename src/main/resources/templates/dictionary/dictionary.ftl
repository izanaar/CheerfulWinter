<div layout="row" >

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
                <md-button class="md-raised md-primary">
                    Translate
                </md-button>
            </md-input-container>
        </div>
        <div>
            srcLang: {{srcLang}}<br>

        </div>
    </div>

    <div flex="50" layout-padding class="md-whiteframe-2dp panel">
        I'm the dictionary template!<br>
        {{testVal}}
    </div>
</div>