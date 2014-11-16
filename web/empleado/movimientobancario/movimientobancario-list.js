app.controller("MovimientoBancarioListController", ["$scope", "$http", function MovimientoBancarioListController($scope, $http) {
        $scope.mostrarTablaMovimiento = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/MovimientosBancarios/"
            }).success(function(data, status, headers, config) {
                $scope.movimientosBancarios = data;
            });
        };
        $scope.mostrarTablaMovimiento();
    
    }]);

