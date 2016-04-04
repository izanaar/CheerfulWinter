<div layout="row" layout-padding="10px">
    <div flex-gt-xs="50">
        <div layout="row" layout-wrap>
            <md-input-container class="input-container-flat" flex="noshrink" layout="row">
                <md-select placeholder="Source language" ng-model="user" md-on-open="loadUsers()">
                    <md-option ng-value="user" ng-repeat="user in users">{{user.name}}</md-option>
                </md-select>
            </md-input-container>
            <md-input-container class="input-container-flat" flex="none">
                <md-button class="md-raised md-primary">
                    Translate
                </md-button>
            </md-input-container>
        </div>

        <md-input-container class="md-block">
            <label>Source text</label>
            <textarea ng-model="user.biography" md-maxlength="150" rows="5" md-select-on-focus=""></textarea>
        </md-input-container>
    </div>

    <div flex-gt-xs="50">
        <md-input-container class="input-container-flat" flex="noshrink">
            <md-select placeholder="Destination language" ng-model="user" md-on-open="loadUsers()">
                <md-option ng-value="user" ng-repeat="user in users">{{user.name}}</md-option>
            </md-select>
        </md-input-container>
        <md-input-container class="md-block">
            <label>Translated</label>
            <textarea ng-model="user.biography" md-maxlength="150" rows="5" md-select-on-focus=""></textarea>
        </md-input-container>
    </div>
</div>