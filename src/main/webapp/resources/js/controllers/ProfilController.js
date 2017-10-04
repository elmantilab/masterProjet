'use strict';

/**
 * CategorieController
 * @constructor
 */
var ProfilController = function($scope, $http) {
    $scope.Profil = {};
    $scope.editMode = false;

    $scope.fetchProfilList = function() {
        $http.get('Profil/Profillist.json').success(function(ProfilList){
            $scope.Profil = ProfilList;
        });
    };

    $scope.addNewProfil = function(Profil) {

        $scope.resetError();

        $http.post('Profil/add', Profil).success(function() {
            $scope.fetchProfilsList();
    
            $scope.Profil.Profil = '';
 
        }).error(function() {
            $scope.setError('Could not add a new Profil');
        });
    };

    $scope.updateProfil = function(Profil) {
        $scope.resetError();

        $http.put('Profil/update', Profil).success(function() {
            $scope.fetchProfilsList();
 
            $scope.Profil.Profil = '';
  
            $scope.editMode = false;
        }).error(function() {
            $scope.setError('Could not update the Profil');
        });
    };

    $scope.editProfil = function(Profil) {
        $scope.resetError();
        $scope.Profil = Profil;
        $scope.editMode = true;
    };

    $scope.removeProfil = function(id) {
        $scope.resetError();

        $http.delete('Profil/remove/' + id).success(function() {
            $scope.fetchProfilList();
        }).error(function() {
            $scope.setError('Could not remove Profil');
        });
        
        $scope.Profil = '';
    };

    $scope.removeAllProfils = function() {
        $scope.resetError();

        $http.delete('Profil/removeAll').success(function() {
            $scope.fetchProfilsList();
        }).error(function() {
            $scope.setError('Could not remove all Profil');
        });

    };

    $scope.resetProfilForm = function() {
        $scope.resetError();
        $scope.Profil = {};
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

    $scope.fetchProfilList();

    $scope.predicate = 'id';
};