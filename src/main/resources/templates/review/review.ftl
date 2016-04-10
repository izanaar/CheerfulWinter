<div class="panel md-whiteframe-2dp" layout="column">
    <div flex="100" class="md-title">Translations:</div>
    <div flex layout="column">
        <div flex="50" ng-repeat="translation in translations">
            Word: {{translation.inputText}}; direction {{translation.inputLanguage}}-{{translation.finalLanguage}}
        </div>
    </div>

</div>