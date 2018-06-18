'use strict';

/**
 * CategorieController
 * @constructor
 */
var MarqueController = function ($scope, $http) {
    $scope.Marque = {};
    $scope.editMode = false;
    $scope.marques = null;
    $scope.editMode = false;
    $scope.viewby = 2;
    $scope.currentPage = 1;
    $scope.itemsPerPage = $scope.viewby;
    $scope.maxSize = 5; //Number of pager buttons to show
    $scope.noty = 'data-noty-options=';
    $scope.msgAlert = '<div class="alert alert-danger"> <button type="button" class="close" data-dismiss="alert">&times;</button> <strong>Attention</strong> Merci d entr� les bons informations.</div>';


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
    $scope.ShowDialog = function (idDialog) {
        $(idDialog).modal('show');
    };
    $scope.setPage = function (pageNo) {
        $scope.currentPage = pageNo;
    };
    $scope.pageChanged = function () {
        console.log('Page changed to: ' + $scope.currentPage);
    };
    $scope.fetchMarquesList = function () {
        $http.get('Marque/Marquelist.json').success(function (MarqueList) {
            $scope.marques = MarqueList;
            $scope.totalItems = MarqueList.length;
        });
    };

    $scope.addNewMarque = function (Marque) {

        $scope.resetError();

        $http.post('Marque/add', Marque).success(function () {
            $scope.fetchMarquesList();

            $scope.Marque.Marque = '';

        }).error(function () {
            $scope.setError('Could not add a new Marque');
        });
    };

    $scope.updateMarque = function (Marque) {
        $scope.resetError();

        $http.put('Marque/update', Marque).success(function () {
            $scope.fetchMarquesList();

            $scope.Marque.Marque = '';

            $scope.editMode = false;
        }).error(function () {
            $scope.setError('Could not update the Marque');
        });
    };

    $scope.editMarque = function (Marque) {
        $scope.resetError();
        $scope.Marque = Marque;
        $scope.editMode = true;
    };

    $scope.removeMarque = function (id) {
        $scope.resetError();

        $http.delete('Marque/remove/' + id).success(function () {
            $scope.fetchMarquesList();
        }).error(function () {
            $scope.setError('Could not remove Marque');
        });

        $scope.Marque = '';
    };

    $scope.removeAllMarques = function () {
        $scope.resetError();

        $http.delete('Marque/removeAll').success(function () {
            $scope.fetchMarquesList();
        }).error(function () {
            $scope.setError('Could not remove all Marque');
        });

    };

    $scope.resetMarqueForm = function () {
        $scope.resetError();
        $scope.Marque = {};
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

    $scope.fetchMarquesList();

    $scope.predicate = 'id';
};