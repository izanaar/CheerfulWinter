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
    <#--<div layout="row">
        <div flex="100" ng-repeat="definition in translation.def" layout="row">
            <div flex="100">{{$index + 1}} {{definition.text}}{{definition.pos}}:</div>
            &lt;#&ndash;<div ng-repeat="translation in definition.tr" flex="100">

                {{translation.text}}({{translation.pos}}, {{translation.gen}}

            </div>
            <hr>&ndash;&gt;
        </div>
    </div>-->
        <div flex style="background-color: crimson" layout="column">
            <div flex-offset="5" style="background-color: green"> tr1 </div>
            <div flex-offset="5" style="background-color: blue">tr2 </div>
        </div>
        <div flex style="background-color: gold">
            <div flex-offset="5" style="background-color: green">tr3</div>
            <div flex-offset="5" style="background-color: green">tr4</div>
        </div>

    </div>
</div>