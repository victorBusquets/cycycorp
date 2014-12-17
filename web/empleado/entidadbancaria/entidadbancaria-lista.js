
app.controller("EntidadBancariaListaController", ["$location","$scope", "$http", function($location,$scope, $http) {


        $scope.cargarEntidadesBancarias = function() {

            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria"
            }).success(function(data) {
                $scope.entidadesBancarias = data;
            }).error(function(data, status, headers, config) {
                 $location.url("/loginrequired");
            });

        };


       $scope.cargarEntidadesBancarias();


        $scope.editar = function(id) {
            location.href = "#/entidadbancaria/detalles/" + id;
        };


        $scope.borrarRegistro = function(id) {

            if (confirm('Do you want to delete Entidad Bancaria ' + id + '?')) {

                $http({
                    method: "DELETE",
                    url: contextPath + "/api/EntidadBancaria/" + id
                }).success(function() {
                    alert("¡Registro borrado!");
                    $scope.cargarEntidadesBancarias();
                }).error(function() {
                    alert("Error: " + status);
                });

            }
        };


    }]);