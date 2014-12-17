app.controller("LoginController", ["$scope", "$rootScope", "$http", "$routeParams", function($scope, $rootScope, $http, $routeParams) {

        $scope.credencial = {
        }

        $scope.login = function() {
            $http({
                method: "POST",
                url: contextPath + "/api/session/empleado",
                data: $scope.credencial
            }).success(function(data, status, headers, config) {
                $rootScope.empleado = data;
                window.location.assign("#/");
                $rootScope.logcheck();
            }).error(function(data, status, headers, config) {
                alert("Error: " + status);
            });
        }
    }]);

