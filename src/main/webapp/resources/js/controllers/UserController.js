'use strict';

/**
 * CategorieController
 * @constructor
 */
var UserController = function($scope, $http) {
    $scope.User = {};
    $scope.editMode = false;

    $scope.fetchUserList = function() {
        $http.get('User/Userlist.json').success(function(UserList){
            $scope.User = UserList;
        });
    };

    $scope.addNewUser = function(User) {

        $scope.resetError();

        $http.post('User/add', User).success(function() {
            $scope.fetchUsersList();
    
            $scope.User.User = '';
 
        }).error(function() {
            $scope.setError('Could not add a new User');
        });
    };

    $scope.updateUser = function(User) {
        $scope.resetError();

        $http.put('User/update', User).success(function() {
            $scope.fetchUsersList();
 
            $scope.User.User = '';
  
            $scope.editMode = false;
        }).error(function() {
            $scope.setError('Could not update the User');
        });
    };

    $scope.editUser = function(User) {
        $scope.resetError();
        $scope.User = User;
        $scope.editMode = true;
    };

    $scope.removeUser = function(id) {
        $scope.resetError();

        $http.delete('User/remove/' + id).success(function() {
            $scope.fetchUserList();
        }).error(function() {
            $scope.setError('Could not remove User');
        });
        
        $scope.User = '';
    };

    $scope.removeAllUsers = function() {
        $scope.resetError();

        $http.delete('User/removeAll').success(function() {
            $scope.fetchUsersList();
        }).error(function() {
            $scope.setError('Could not remove all User');
        });

    };

    $scope.resetUserForm = function() {
        $scope.resetError();
        $scope.User = {};
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

    $scope.fetchUserList();

    $scope.predicate = 'id';
};