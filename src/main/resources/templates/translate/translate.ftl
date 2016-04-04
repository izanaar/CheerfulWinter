<div layout="row" layout-padding="10px">
    <div flex-gt-xs="50">
        <div layout="row">
            <span flex="33" class="md-subhead">Source language:</span>

        </div>

        <md-input-container class="md-block">
            <label>Source text</label>
            <textarea ng-model="user.biography" md-maxlength="150" rows="5" md-select-on-focus=""></textarea>
        </md-input-container>
    </div>

    <div flex-gt-xs="50">
        <div layout="row">
            <span flex="33" class="md-subhead">Destination language:</span>

        </div>
        <md-input-container class="md-block">
            <label>Translation</label>
            <textarea ng-model="user.biography" md-maxlength="150" md-select-on-focus=""></textarea>
        </md-input-container>
    </div>
</div>