'use strict';

/**
 * ClientController
 * @constructor
 */
var ClientController = function($scope, $http) {
    $scope.fetchClientsList = function() {
        $http.get('client/carlist.json').success(function(carList){
            $scope.client = carList;
        });
    };

    $scope.addNewClient = function(newClient) {
        $http.post('client/addClient/' + newClient).success(function() {
            $scope.fetchClientsList();
        });
         $scope.nom = '';
         $scope.prenom = '';
         $scope.Email = '';
         
    };

    $scope.removeClient = function(car) {
        $http.delete('client/removeClient/' + car).success(function() {
            $scope.fetchClientsList();
        });
    };

    $scope.removeAllClient = function() {
        $http.delete('client/removeAllClient').success(function() {
            $scope.fetchClientsList();
        });

    };

    $scope.fetchClientList();
};