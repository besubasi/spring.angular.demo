(function () {
    'use strict';

    angular
        .module('app')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['AuthenticationService', '$location', '$rootScope', 'FlashService'];
    function LoginController(AuthenticationService, $location, $rootScope, FlashService) {
        var vm = this;
        vm.login = login;
        function login() {
            vm.dataLoading = true;
            AuthenticationService.Login(vm.username, vm.password)
                .then(function (response) {
                    if (response.success) {
                    	AuthenticationService.SetCredentials(vm.username, vm.password);
                        $location.path('/home');
                    } else {
                        FlashService.Error(response.message);
                        vm.dataLoading = false;
                    }
                });
        }
    }
})();
