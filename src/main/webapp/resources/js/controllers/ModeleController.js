'use strict';

/**
 * CategorieController
 * @constructor
 */
var ModeleController = function($scope, $http) {
    $scope.Modele = {};
    $scope.editMode = false;

    $scope.fetchModeleList = function() {
        $http.get('Modele/Modelelist.json').success(function(ModeleList){
            $scope.Modele = ModeleList;
        });
    };

    $scope.addNewCategorie = function(Modele) {

        $scope.resetError();

        $http.post('Modele/add', Modele).success(function() {
            $scope.fetchModelesList();
    
            $scope.Modele.Modele = '';
 
        }).error(function() {
            $scope.setError('Could not add a new Modele');
        });
    };

    $scope.updateModele = function(Modele) {
        $scope.resetError();

        $http.put('Modele/update', Modele).success(function() {
            $scope.fetchCategoriesList();
 
            $scope.Modele.Modele = '';
  
            $scope.editMode = false;
        }).error(function() {
            $scope.setError('Could not update the Profil');
        });
    };

    $scope.editModele = function(Modele) {
        $scope.resetError();
        $scope.Modele = Modele;
        $scope.editMode = true;
    };

    $scope.removeModele = function(id) {
        $scope.resetError();

        $http.delete('Modele/remove/' + id).success(function() {
            $scope.fetchModeleList();
        }).error(function() {
            $scope.setError('Could not remove Modele');
        });
        
        $scope.Modele = '';
    };

    $scope.removeAllModeles = function() {
        $scope.resetError();

        $http.delete('Modele/removeAll').success(function() {
            $scope.fetchModelesList();
        }).error(function() {
            $scope.setError('Could not remove all Modele');
        });

    };

    $scope.resetModeleForm = function() {
        $scope.resetError();
        $scope.Modele = {};
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

    $scope.fetchModeleList();

    $scope.predicate = 'id';
};