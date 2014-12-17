
app.controller("EntidadBancariaDetallesInsertController", ["$scope", "$http", "$routeParams", function ($scope, $http, $routeParams) {

        $scope.entidadBancaria = {
            idEntidadBancaria: "",
            nombre: "",
            codigoEntidad: ""
        };

        $scope.action = "insert";


        $scope.insertarRegistro = function () {

            $http({
                method: "POST",
                url: contextPath + "/api/EntidadBancaria/",
                data: $scope.entidadBancaria
            }).success(function () {
                alert("¡Registro insertado!");
                window.location.assign("#/entidadbancaria/entidades");
            }).error(function (status) {
                alert("Error " + status);
            });
        };

    }]);


app.controller("EntidadBancariaDetallesUpdateController", ["$scope", "$http", "$routeParams", function ($scope, $http, $routeParams) {

        $scope.action = "update";

        $scope.buscarRegistro = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria/" + $routeParams.id
            }).success(function (data) {
                $scope.entidadBancaria = data;
            }).error(function (status) {
                alert("Error " + status);
            });
        };


        $scope.buscarRegistro($routeParams.id);

        $scope.modificarRegistro = function () {
            $http({
                method: "PUT",
                url: contextPath + "/api/EntidadBancaria/",
                data: $scope.entidadBancaria
            }).success(function () {
                alert("¡Registro modificado!");
                window.location.assign("#/entidadbancaria/entidades");
            }).error(function () {
                alert("¡Que no va!");
            });
        };

    }]);