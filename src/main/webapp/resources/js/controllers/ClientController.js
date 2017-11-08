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
    $scope.addNewClient = function(client) {

        $scope.resetError();

        $http.post('clients/add', client).success(function() {
        
            $scope.client.client = '';
 
        }).error(function() {
            $scope.setError('Could not add a new station');
        });
    };
    $scope.updateClient = function(client) {
        $scope.resetError();

        $http.put('clients/update', client).success(function() {
          
 
            $scope.clients.client = '';
  
            $scope.editMode = false;
        }).error(function() {
            $scope.setError('Could not update the categorie');
        });
    };

 $scope.editClient = function(client) {
        $scope.resetError();
        $scope.client = client;
        $scope.editMode = true;
    };
    $scope.removeClient = function(id) {
        $scope.resetError();

        $http.delete('clients/remove/' + id).success(function() {
            
        }).error(function() {
            $scope.setError('Could not remove categorie');
        });
        
        $scope.client = '';
    };
    $scope.fetchClientsList() ;
};