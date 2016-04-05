<div flex layout-padding="10px">

    <div layout="column">
        <div flex layout="row">
            <div layout="row" flex="50">
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
            <div layout="row" flex="50" layout-align="start center">
                <md-input-container class="input-container-flat" flex="noshrink" layout="row">
                    <md-select placeholder="Source language" ng-model="user" md-on-open="loadUsers()">
                        <md-option ng-value="user" ng-repeat="user in users">{{user.name}}</md-option>
                    </md-select>
                </md-input-container>

            </div>
        </div>
        <div flex layout="row">
            <div flex>
                <md-input-container class="md-block">
                    <label>Source text</label>
                    <textarea ng-model="user.biography" md-maxlength="150" rows="5" md-select-on-focus=""></textarea>
                </md-input-container>
            </div>
            <div flex>
                <md-input-container class="md-block">
                    <label>Source text</label>
                    <textarea ng-model="user.biography" md-maxlength="150" rows="5" md-select-on-focus=""></textarea>
                </md-input-container>
            </div>
        </div>
    </div>

</div>


