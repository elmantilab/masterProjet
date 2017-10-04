'use strict';

/**
 * CategorieController
 * @constructor
 */
var VehiculeController = function($scope, $http) {
    $scope.Vehicule = {};
    $scope.editMode = false;

    $scope.fetchVehiculeList = function() {
        $http.get('Vehicule/Vehiculelist.json').success(function(VehiculeList){
            $scope.Vehicule = VehiculeList;
        });
    };

    $scope.addNewCategorie = function(Vehicule) {

        $scope.resetError();

        $http.post('Vehicule/add', Vehicule).success(function() {
            $scope.fetchVehiculesList();
    
            $scope.Vehicule.Vehicule = '';
 
        }).error(function() {
            $scope.setError('Could not add a new Vehicule');
        });
    };

    $scope.updateVehicule = function(Vehicule) {
        $scope.resetError();

        $http.put('Vehicule/update', Vehicule).success(function() {
            $scope.fetchCategoriesList();
 
            $scope.Vehicule.Vehicule = '';
  
            $scope.editMode = false;
        }).error(function() {
            $scope.setError('Could not update the categorie');
        });
    };

    $scope.editVehicule = function(Vehicule) {
        $scope.resetError();
        $scope.Vehicule = Vehicule;
        $scope.editMode = true;
    };

    $scope.removeVehicule = function(id) {
        $scope.resetError();

        $http.delete('Vehicule/remove/' + id).success(function() {
            $scope.fetchVehiculeList();
        }).error(function() {
            $scope.setError('Could not remove Vehicule');
        });
        
        $scope.Vehicule = '';
    };

    $scope.removeAllVehicules = function() {
        $scope.resetError();

        $http.delete('Vehicule/removeAll').success(function() {
            $scope.fetchVehiculesList();
        }).error(function() {
            $scope.setError('Could not remove all Vehicule');
        });

    };

    $scope.resetVehiculeForm = function() {
        $scope.resetError();
        $scope.Vehicule = {};
        $scope.editMode = false;
    };

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.fetchVehiculeList();

    $scope.predicate = 'id';
};