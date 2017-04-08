(function () {
    'use strict';

    angular
        .module('app')
        .factory('UserService', UserService);

    UserService.$inject = ['$http'];
    function UserService($http) {
        var service = {};

        service.Create = Create;
        service.GetAll = GetAll;
        service.Delete = Delete;

        return service;
        
        
        function Create(user) {        	
            return $http.post('/register', user).then(handleSuccess, handleError('Error creating user'));
        }


        function GetAll() {
            return $http.get('/users').then(handleSuccess, handleError('Error getting all users'));
        }


        function Delete(username) {
        	$http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded; charset=UTF-8';
            return $http.post('/delete', 'username=' + username).then(handleSuccess, handleError('Error deleting user'));
        }

        // private functions

        function handleSuccess(res) {
            return res.data;
        }

        function handleError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    }

})();
