app.controller("ClienteListController", ["$location","$scope", "$http", function ClientesListController($location,$scope, $http) {

    $scope.mostrarTablaCliente = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/Clientes/"
            }).success(function(data) {
                $scope.clientes = data;
            }).error(function() {
                $location.url("/loginrequired");
            });
        };
        $scope.mostrarTablaCliente();

}]);