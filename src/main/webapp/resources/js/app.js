'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', ['AngularSpringApp.filters', 'AngularSpringApp.services', 'AngularSpringApp.directives']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/categories', {
            templateUrl: 'categories/layout',
            controller: CategorieController
        });
        $routeProvider.when('/cars', {
            templateUrl: 'cars/layout',
            controller: CarController
        });

        $routeProvider.when('/trains', {
            templateUrl: 'trains/layout',
            controller: TrainController
        });

        $routeProvider.when('/railwaystations', {
            templateUrl: 'railwaystations/layout',
            controller: RailwayStationController
        });
        
        
        //---------------------nabil----------------//
         $routeProvider.when('/cleint', {
            templateUrl: 'client/layout',
            controller: ClientController
        });
        
         $routeProvider.when('/user', {
            templateUrl: 'User/layout',
            controller: UserController
        });
        
          $routeProvider.when('/Profil', {
            templateUrl: 'Profil/layout',
            controller: ProfilController
        });
        
          $routeProvider.when('/Vehicule', {
            templateUrl: 'Vehicule/layout',
            controller: VehiculeController
        });
           $routeProvider.when('/Modele', {
            templateUrl: 'Modele/layout',
            controller: ModeleController
        });
            $routeProvider.when('/Marque', {
            templateUrl: 'Marque/layout',
            controller: MarqueController
        });
        
         $routeProvider.when('/Marque', {
            templateUrl: 'Marque/layout',
            controller: MarqueController
        });
        
        
        


        $routeProvider.otherwise({redirectTo: '/categories'});
    }]);
