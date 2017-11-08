'use strict';

/**
 * CategorieController 
 * @constructor
 */
var CategorieController = function($scope, $http) {
    $scope.categorie = {};
    $scope.editMode = false;
    $scope.fetchCategoriesList = function() {
        $http.get('categories/categorielist.json').success(function(categorieList){
            $scope.categories = categorieList;
        });
    };

    $scope.addNewCategorie = function(categorie) {

        $scope.resetError();

        $http.post('categories/add', categorie).success(function() {
            $scope.fetchCategoriesList();
    
            $scope.categorie.categorie = '';
 
        }).error(function() {
            $scope.setError('Could not add a new station');
        });
    };

    $scope.updateCategorie = function(categorie) {
        $scope.resetError();

        $http.put('categories/update', categorie).success(function() {
            $scope.fetchCategoriesList();
 
            $scope.categorie.categorie = '';
  
            $scope.editMode = false;
        }).error(function() {
            $scope.setError('Could not update the categorie');
        });
    };

    $scope.editCategorie = function(categorie) {
        $scope.resetError();
        $scope.categorie = categorie;
        $scope.editMode = true;
    };

    $scope.removeCategorie = function(id) {
        $scope.resetError();

        $http.delete('categories/remove/' + id).success(function() {
            $scope.fetchCategoriesList();
        }).error(function() {
            $scope.setError('Could not remove categorie');
        });
        
        $scope.categorie = '';
    };

    $scope.removeAllCategories = function() {
        $scope.resetError();

        $http.delete('categories/removeAll').success(function() {
            $scope.fetchCategoriesList();
        }).error(function() {
            $scope.setError('Could not remove all Categories');
        });

    };

    $scope.resetCategorieForm = function() {
        $scope.resetError();
        $scope.categorie = {};
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

    $scope.fetchCategoriesList();

    $scope.predicate = 'id';
};