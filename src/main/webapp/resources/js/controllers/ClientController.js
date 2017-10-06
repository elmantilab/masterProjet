'use strict';

/**
 * ClientController
 * @constructor
 */
var ClientController = function($scope, $http) {
 
    $scope.fetchClientsList = function() {
        $http.get('clients/clientlist.json').success(function(clientlist){
            $scope.clients = clientlist;
        });
    };

    $scope.fetchClientsList() ;
};