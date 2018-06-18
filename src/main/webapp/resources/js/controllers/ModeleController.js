'use strict';

/**
 * ModeleController
 * @constructor
 */
var ModeleController = function ($scope, $http, $rootScope) {
    $rootScope.marques = null;
    $scope.Modele = {};
    $scope.sizes = [
        "small (12-inch)",
        "medium (14-inch)",
        "large (16-inch)",
        "insane (42-inch)"
    ];
    $scope.editMode = false;
    $scope.viewby = 2;
    $scope.currentPage = 1;
    $scope.itemsPerPage = $scope.viewby;
    $scope.maxSize = 5; //Number of pager buttons to show

    $scope.setPage = function (pageNo) {
        $scope.currentPage = pageNo;
    };
    $scope.pageChanged = function () {
        console.log('Page changed to: ' + $scope.currentPage);
    };
    $scope.setItemsPerPage = function (num) {
        $scope.itemsPerPage = num;
        $scope.currentPage = 1; //reset to first page
    }
    $scope.indexListModele = null;
    $scope.Cat = null;
    $rootScope.modeles = null;

    $scope.editMode = false;
    $scope.msg = null;
    $scope.noty = 'data-noty-options=';
    $scope.msgAlert = '<div class="alert alert-danger"> <button type="button" class="close" data-dismiss="alert">&times;</button> <strong>Attention</strong> Merci d entr� les bons informations.</div>';
    $scope.msgError = function (msg) {
        $scope.msg = {"text": msg, "layout": "topRight", "type": "error"};
    };
    $scope.msgInformation = function (msg) {
        $scope.msg = {"text": "Votre insertion � �t� bien effectu�", "layout": "topRight", "type": "success"};
    };
    $scope.ShowDialog = function (idDialog) {
        $(idDialog).modal('show');
    };

    $scope.fetchModeleList = function () {
        $http.get('Modele/Modelelist.json').success(function (ModeleList) {
            $rootScope.modeles = ModeleList;
        });
    };
    /***List Des Modeles***/
    $scope.addNewModele = function (Modele) {

        $scope.resetError();

        $http.post('Modele/add', Modele).success(function () {
            $scope.fetchModelesList();

            $scope.Modele.Modele = '';

        }).error(function () {
            $scope.setError('Could not add a new Modele');
        });
    };   /***End List***/


    /***Update Modele***/
    $scope.updateModele = function (Modele, index) {
        $scope.resetError();

        $http.put('Modele/update' + index, Modele).success(function () {
            $scope.fetchModelesList();

            $scope.Modele.name = '';

            $scope.editMode = false;
        }).error(function () {
            $scope.setError('Could not update the Profil');
        });
    };
    /***End Modele***/



    /***  Edit ***/
    $scope.editModele = function (Modele, index) {
        $scope.resetError();
        $scope.indexListModele = index;
        $scope.Modele = Modele;
        $scope.editMode = true;
    };
    /***End Edit***/

    $scope.removeModele = function (id) {
        $scope.resetError();

        $http.delete('Modele/remove/' + id).success(function () {
            $scope.fetchModeleList();
        }).error(function () {
            $scope.setError('Could not remove Modele');
        });

        $scope.Modele = '';
    };

    $scope.removeAllModeles = function () {
        $scope.resetError();

        $http.delete('Modele/removeAll').success(function () {
            $scope.fetchModelesList();
        }).error(function () {
            $scope.setError('Could not remove all Modele');
        });

    };

    /***Get Marque***/
    $scope.getMarque = function () {
        $http.get('Marques/Marquelist.json').success(function (ListMarque) {
            $rootScope.marques = ListMarque;
        });
    };


    $scope.resetModeleForm = function () {
        $scope.resetError();
        $scope.Modele = {};
        $scope.editMode = false;
    };

    $scope.resetError = function () {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.setError = function (message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.fetchModeleList();

    $scope.predicate = 'id';
};