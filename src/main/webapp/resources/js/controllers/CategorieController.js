'use strict';

/**
 * CategorieController
 * @constructor
 */
var CategorieController = function ($scope, $http, $rootScope) {
    $scope.indexListCategorie = null;
    $scope.Cat = null;
    $rootScope.categories = null;
    $scope.categorie = {};
    $scope.editMode = false;
    $scope.msg = null;
    $scope.noty = 'data-noty-options=';
    $scope.msgAlert = '<div class="alert alert-danger"> <button type="button" class="close" data-dismiss="alert">&times;</button> <strong>Attention</strong> Merci d entré les bons informations.</div>';
    $scope.msgError = function (msg) {
        $scope.msg = {"text": msg, "layout": "topRight", "type": "error"};
    };
    $scope.msgInformation = function (msg) {
        $scope.msg = {"text": msg, "layout": "topRight", "type": "information"};
    };



    $scope.ShowDialog = function (idDialog) {
        $(idDialog).modal('show');
    };
    $scope.fetchCategoriesList = function () {
        $http.get('categories/categorielist.json').success(function (categorieList) {
            $rootScope.categories = categorieList;
        });
    };

    $scope.addNewCategorie = function (categorie) {

        $scope.resetError();

        $http.post('categories/add', categorie).success(function () {

            $rootScope.categories = $scope.fetchCategoriesList();
            $scope.categorie.categorie = '';
            $scope.msgInformation("Votre inerstion à été bien effectué");
        }).error(function () {
            $scope.setError($scope.msgAlert);
            $scope.setError('Could not add a new station');

        });
    };

    $scope.updateCategorie = function (categorie, index) {
        //$scope.resetError();
        console.log('index ' + index);
        console.log(categorie);
//        index = $scope.indexListCategorie = ;
        $scope.Cat = {categorie, 'index ': index}
        $http.post('categories/update', {'index ': index}).success(function () {
            $scope.indexListCategorie = index;
            $rootScope.categories = $scope.fetchCategoriesList();

            $scope.categorie.categorie = categorie.categorie;

            $scope.editMode = false;
        }).error(function () {
            $scope.setError('Could not update the categorie');
        });
    };

    $scope.editCategorie = function (categorie, index) {
//        console.log(index);
        $scope.indexListCategorie = index;
//        console.log(categorie);
        $scope.resetError();
        $scope.categorie = categorie;
        $scope.editMode = true;
    };

    $scope.removeCategorie = function (id) {
        $scope.resetError();

        $http.delete('categories/remove/' + id).success(function () {
            $scope.fetchCategoriesList();
        }).error(function () {
            $scope.setError('Could not remove categorie');
        });

        $scope.categorie = '';
    };
    $scope.remove = function (id) {
        $scope.resetError();

        $http.delete('categories/delete/' + id).success(function () {
            $scope.fetchCategoriesList();
        }).error(function () {
            $scope.setError('Could not remove categorie');
        });

        $scope.categorie = '';
    };

    $scope.removeAllCategories = function () {
        $scope.resetError();

        $http.delete('categories/removeAll').success(function () {
            $scope.fetchCategoriesList();
        }).error(function () {
            $scope.setError('Could not remove all Categories');
        });

    };

    $scope.resetCategorieForm = function () {
        $scope.resetError();
        $scope.categorie = {};
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

    $scope.fetchCategoriesList();

    $scope.predicate = 'id';
};