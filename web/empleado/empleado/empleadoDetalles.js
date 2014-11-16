
app.controller("EmpleadoDetallesInsertController", ["$scope", "$http", "$routeParams", function ($scope, $http, $routeParams) {

        $scope.empleado = {
        };

        $scope.editar = false;
        $scope.insertar = true;

        $scope.insertarRegistro = function () {

            $http({
                method: "POST",
                url: contextPath + "/api/Empleado",
                data: $scope.empleado
            }).success(function () {
                alert("¡Registro insertado!");
                window.location.assign("#/empleado/empleados");
            }).error(function (status) {
                alert("Error " + status);
            });
        };

    }]);


app.controller("EmpleadoDetallesUpdateController", ["$scope", "$http", "$routeParams", function ($scope, $http, $routeParams) {

        $scope.editar = true;
        $scope.insertar = false;

        $scope.buscarRegistro = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/Empleado/" + $routeParams.id
            }).success(function (data) {
                $scope.empleado = data;
            }).error(function (status) {
                alert("Error " + status);
            });
        };


        $scope.buscarRegistro($routeParams.id);

        $scope.modificarRegistro = function () {
            $http({
                method: "PUT",
                url: contextPath + "/api/Empleado/",
                data: $scope.empleado
            }).success(function () {
                alert("¡Registro modificado!");
                window.location.assign("#/empleado/empleados");
            }).error(function () {
                alert("¡Que no va!");
            });
        };

    }]);