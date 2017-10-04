'use strict';

/**
 * CategorieController
 * @constructor
 */
var MarqueController = function($scope, $http) {
    $scope.Marque = {};
    $scope.editMode = false;

    $scope.fetchMarqueList = function() {
        $http.get('Marque/Marquelist.json').success(function(MarqueList){
            $scope.Marque = MarqueList;
        });
    };

    $scope.addNewMarque = function(Marque) {

        $scope.resetError();

        $http.post('Marque/add', Marque).success(function() {
            $scope.fetchMarquesList();
    
            $scope.Marque.Marque = '';
 
        }).error(function() {
            $scope.setError('Could not add a new Marque');
        });
    };

    $scope.updateMarque = function(Marque) {
        $scope.resetError();

        $http.put('Marque/update', Marque).success(function() {
            $scope.fetchMarquesList();
 
            $scope.Marque.Marque = '';
  
            $scope.editMode = false;
        }).error(function() {
            $scope.setError('Could not update the Marque');
        });
    };

    $scope.editMarque = function(Marque) {
        $scope.resetError();
        $scope.Marque = Marque;
        $scope.editMode = true;
    };

    $scope.removeMarque = function(id) {
        $scope.resetError();

        $http.delete('Marque/remove/' + id).success(function() {
            $scope.fetchMarqueList();
        }).error(function() {
            $scope.setError('Could not remove Marque');
        });
        
        $scope.Marque = '';
    };

    $scope.removeAllMarques = function() {
        $scope.resetError();

        $http.delete('Marque/removeAll').success(function() {
            $scope.fetchMarquesList();
        }).error(function() {
            $scope.setError('Could not remove all Marque');
        });

    };

    $scope.resetMarqueForm = function() {
        $scope.resetError();
        $scope.Marque = {};
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

    $scope.fetchMarqueList();

    $scope.predicate = 'id';
};