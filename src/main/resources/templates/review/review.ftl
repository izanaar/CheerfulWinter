<div class="panel md-whiteframe-2dp" layout="column">

    <md-grid-list md-cols="3" md-row-height="11:1">
        <md-grid-tile ng-repeat="translation in translations">
            <h4 class="md-body-2">{{translation.inputText}}
            {{translation.inputLanguage}}-{{translation.finalLanguage}}
            </h4>
        </md-grid-tile>
    </md-grid-list>

</div>