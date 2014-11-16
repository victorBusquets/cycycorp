app.controller("ClienteListController", ["$scope", "$http", function ClientesListController($scope, $http) {

    $scope.mostrarTablaCliente = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/Clientes/"
            }).success(function(data, status, headers, config) {
                $scope.clientes = data;
               // alert("Se muestra tabla");
            }).error(function(data, status, headers, config) {
                alert("Error no se muestra nada"+status);
            });
        };
        $scope.mostrarTablaCliente();

}]);