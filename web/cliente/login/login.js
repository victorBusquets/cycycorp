app.controller("LoginController", ["$scope","$rootScope", "$http", "$routeParams", function($scope,$rootScope, $http, $routeParams) {

        $scope.credencial = {
        };

        $scope.login = function() {
            $http({
                method: "POST",
                url: contextPath + "/api/session/cliente",
                data: $scope.credencial
            }).success(function() {
                $rootScope.logeado = true;
                window.location.assign("#/");
            }).error(function(status) {
                alert("Error: " + status);
            });
        };
}]);

app.controller("LogoutController", ["$scope","$rootScope", "$http", "$routeParams", function($scope,$rootScope, $http, $routeParams) {
        $scope.logout = function() {
            $http({
                method: "DELETE",
                url: contextPath + "/api/session/cliente"
            }).success(function() {
                $rootScope.logeado = false;
                window.location.assign("#/");
            }).error(function(status) {
                alert("Error: " + status);
            });
        };
         $scope.logout();
    }]);