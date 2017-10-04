'use strict';

/**
 * CategorieController
 * @constructor
 */
var ContratController = function($scope, $http) {
    $scope.Contrat = {};
    $scope.editMode = false;

    $scope.fetchContratList = function() {
        $http.get('Contrat/Contratlist.json').success(function(ContratList){
            $scope.Contrat = ContratList;
        });
    };

    $scope.addNewCategorie = function(Contrat) {

        $scope.resetError();

        $http.post('Contrat/add', Contrat).success(function() {
            $scope.fetchContratsList();
    
            $scope.Contrat.Contrat = '';
 
        }).error(function() {
            $scope.setError('Could not add a new Contrat');
        });
    };

    $scope.updateContrat = function(Contrat) {
        $scope.resetError();

        $http.put('Contrat/update', Contrat).success(function() {
            $scope.fetchCategoriesList();
 
            $scope.Contrat.Contrat = '';
  
            $scope.editMode = false;
        }).error(function() {
            $scope.setError('Could not update the categorie');
        });
    };

    $scope.editContrat = function(Contrat) {
        $scope.resetError();
        $scope.Contrat = Contrat;
        $scope.editMode = true;
    };

    $scope.removeContrat = function(id) {
        $scope.resetError();

        $http.delete('Contrat/remove/' + id).success(function() {
            $scope.fetchContratList();
        }).error(function() {
            $scope.setError('Could not remove Contrat');
        });
        
        $scope.Contrat = '';
    };

    $scope.removeAllContrats = function() {
        $scope.resetError();

        $http.delete('Contrat/removeAll').success(function() {
            $scope.fetchContratsList();
        }).error(function() {
            $scope.setError('Could not remove all Contrat');
        });

    };

    $scope.resetContratForm = function() {
        $scope.resetError();
        $scope.Contrat = {};
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

    $scope.fetchContratList();

    $scope.predicate = 'id';
};