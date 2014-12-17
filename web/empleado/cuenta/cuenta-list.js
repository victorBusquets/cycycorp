app.controller("CuentaListController", ["$location","$scope", "$http", function CuentaListController($location,$scope, $http) {
        $scope.mostrarTablaCuenta = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/cuentas"
            }).success(function(data, status, headers, config) {
                $scope.cuentas = data;
            }).error(function(data, status, headers, config) {
                $location.url("/loginrequired");
            });
        };
        $scope.mostrarTablaCuenta();

    }]);

