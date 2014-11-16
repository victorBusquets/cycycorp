app.controller("ClienteDetailDeleteController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {

        $scope.action='delete';
        $scope.buscarCliente = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/Cliente/" + $routeParams.id

            }).success(function(data, status, headers, config) {
                $scope.cliente = data;
            }).error(function(data, status, headers, config) {
                alert("No existe o no se pudo encontrar: " );
            });

        };
            $scope.buscarCliente();

        $scope.deleteCliente = function(idCliente) {
            $http({
                method: "DELETE",
                url: contextPath + "/api/Cliente/" +idCliente
            }).success(function(data, status, headers, config) {
                alert("Se ha borrado corrrectamente");
                window.location.assign("#/cliente/clientes");
            }).error(function(data, status, headers, config) {
                alert("no Existe o no se pudo borrar");
            });
        };



    }]);







app.controller("ClienteDetailModificarController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {
        $scope.action='update';
        $scope.buscarCliente = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/Cliente/" + $routeParams.id

            }).success(function(data, status, headers, config) {
                $scope.cliente = data;
            }).error(function(data, status, headers, config) {
                alert("No existe o no se pudo encontrar: " );
            });

        };
            $scope.buscarCliente();

        $scope.modificarCliente = function() {
            $http({
                method: "PUT",
                url: contextPath + "/api/Cliente",
                data: $scope.cliente
            }).success(function(data, status, headers, config) {     
                alert("Se ha modificado corrrectamente "+status+" "+data);
                window.location.assign("#/cliente/clientes");
            }).error(function(data, status, headers, config) {
                alert("no se pudo modificar o no existe");
            });
        };
        
        
}]);

app.controller("ClienteDetailInsertController", ["$scope", "$http", function($scope, $http) {
        $scope.action='insert';
        $scope.insertarCliente = function() {
            $http({
                method: "POST",
                url: contextPath + "/api/Cliente/",
                data: $scope.cliente
            }).success(function(data, status, headers, config) {
                alert("Se ha insertado corrrectamente");
                window.location.assign("#/cliente/clientes");
            }).error(function(data, status, headers, config) {
                alert("no se pudo insertar la entidad");
            });
        };
        
    }]);





