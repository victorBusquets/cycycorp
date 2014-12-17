app.controller("MovimientoBancarioListController", ["$location","$scope", "$http", function MovimientoBancarioListController($location,$scope, $http) {
        $scope.getMovimientos = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/MovimientosBancarios/"
            }).success(function(data, status, headers, config) {
                $scope.movimientosBancarios = data;
            }).error(function(data, status, headers, config) {
                 $location.url("/loginrequired");
            });
        };
        $scope.getMovimientos();

    }]);

