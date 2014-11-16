app.controller("CuentaDetailDeleteController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {
$scope.action="delete";
        $scope.buscarCuenta = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/cuenta/" + $routeParams.id

            }).success(function(data, status, headers, config) {
                $scope.cuenta = data;
            }).error(function(data, status, headers, config) {
                alert("No existe o no se pudo encontrar: " );
            });

        };
            $scope.buscarCuenta();

        $scope.deleteCuenta = function(id) {
            alert(id);
            $http({
                method: "DELETE",
                url: contextPath + "/api/cuenta/" +id
            }).success(function(data, status, headers, config) {
                alert("Se ha borrado correctamente");
                  window.location.assign("#/cuenta/cuentas");
            }).error(function(data, status, headers, config) {
                alert("no Existe o no se pudo borrar");
            });
        };



    }]);


app.controller("CuentaDetailModificarController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {
        $scope.action="update";
        $scope.buscarCuenta = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/cuenta/" + $routeParams.id

            }).success(function(data, status, headers, config) {
                $scope.cuenta = data;
            }).error(function(data, status, headers, config) {
                alert("No existe o no se pudo encontrar: " );
            });

        };
            $scope.buscarCuenta();

        $scope.modificarCuenta = function() {
            $http({
                method: "PUT",
                url: contextPath + "/api/cuenta",
                data: $scope.cuenta
            }).success(function(data, status, headers, config) {
                    
                alert("Se ha modificado correctamente "+status+" "+data);
                  window.location.assign("#/cuenta/cuentas");
            }).error(function(data, status, headers, config) {
                alert("no se pudo modificar o no existe");
            });
        };
        
        
}]);

app.controller("CuentaDetailInsertarController", ["$scope", "$http", function($scope, $http) {
        $scope.action="insert";
        $scope.insertarCuenta = function() {
            $http({
                method: "POST",
                url: contextPath + "/api/cuenta/",
                data: $scope.cuenta
            }).success(function(data, status, headers, config) {
                alert("Se ha insertado correctamente");
                  window.location.assign("#/cuenta/cuentas");
            }).error(function(data, status, headers, config) {
                alert("no se pudo insertar la cuenta");
            });
        }; 
    }]);

