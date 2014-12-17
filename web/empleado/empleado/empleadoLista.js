
app.controller("EmpleadoListaController", ["$location","$scope", "$http", function($location,$scope, $http) {


        $scope.cargarEntidadesBancarias = function() {

            $http({
                method: "GET",
                url: contextPath + "/api/Empleado"
            }).success(function(data) {
                $scope.empleados = data;
            }).error(function(data, status) {
                 $location.url("/loginrequired");
            });

        };


        $scope.cargarEntidadesBancarias();


        $scope.editar = function(id) {
            location.href = "#/empleado/detalles/" + id;
        };


        $scope.borrarRegistro = function(id) {

            if (confirm('Do you want to delete Empleado ' + id + '?')) {

                $http({
                    method: "DELETE",
                    url: contextPath + "/api/Empleado/" + id
                }).success(function() {
                    alert("¡Registro borrado!");
                    $scope.cargarEntidadesBancarias();
                }).error(function() {
                    alert("Error: " + status);
                });

            }
        };


    }]);