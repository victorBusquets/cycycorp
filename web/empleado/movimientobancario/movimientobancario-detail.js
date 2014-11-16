app.controller("MovimientoBancarioDetailDeleteController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {

        $scope.action="delete";
        $scope.buscarMovimiento = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/MovimientoBancario/" + $routeParams.id

            }).success(function(data, status, headers, config) {
                $scope.movimientoBancario = data;
            }).error(function(data, status, headers, config) {
                alert("No existe o no se pudo encontrar: " );
            });

        };
            $scope.buscarMovimiento();

        $scope.deleteMovimiento = function(id) {
            $http({
                method: "DELETE",
                url: contextPath + "/api/MovimientoBancario/" +id
            }).success(function(data, status, headers, config) {
                alert("Se ha borrado correctamente");
                window.location.assign("#/movimientobancario/MovimientoBancarios");
            }).error(function(data, status, headers, config) {
                alert("no Existe o no se pudo borrar");
            });
        };



    }]);

app.controller("MovimientoBancarioDetailModificarController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {
        $scope.action="update";
        $scope.buscarMovimiento = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/MovimientoBancario/" + $routeParams.id

            }).success(function(data, status, headers, config) {
                $scope.movimientoBancario = data;
            }).error(function(data, status, headers, config) {
                alert("No existe o no se pudo encontrar: " );
            });

        };
            $scope.buscarMovimiento();

        $scope.modificarMovimiento = function() {
            $http({
                method: "PUT",
                url: contextPath + "/api/MovimientoBancario/"+$routeParams.id,
                data: $scope.movimientoBancario
            }).success(function(data, status, headers, config) {
                    
                alert("Se ha modificado correctamente "+status+" "+data);
                window.location.assign("#/movimientobancario/MovimientoBancarios");
            }).error(function(data, status, headers, config) {
                alert("no se pudo modificar o no existe");
            });
        };
        
        
}]);

app.controller("MovimientoBancarioDetailInsertarController", ["$scope", "$http",  function($scope, $http) {
$scope.action="insert";
        $scope.insertarMovimiento = function() {
            $http({
                method: "POST",
                url: contextPath + "/api/MovimientoBancario",
                data: $scope.movimientoBancario
            }).success(function(data, status, headers, config) {
                alert("Se ha insertado correctamente"+data);
                window.location.assign("#/movimientobancario/MovimientoBancarios");
            }).error(function(data, status, headers, config) {
                alert("no se pudo insertar el Movimiento");
            });
        };
        
    }]);




