app.controller("CuentaListController", ["$scope", "$http", function CuentaListController($scope, $http) {
        $scope.mostrarTablaCuenta = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/cuentas"
            }).success(function(data, status, headers, config) {
                $scope.cuentas = data;
            });
        };
        $scope.mostrarTablaCuenta();
    
    }]);

