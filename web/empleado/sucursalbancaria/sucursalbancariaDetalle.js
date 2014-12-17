 app.controller("SucursalbancariaDetalleDeleteController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {
        $scope.getSucursal = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria/" + $routeParams.id
            }).success(function(data, status, headers, config) {
                $scope.sucursalBancaria = data;
            }).error(function(data, status, headers, config) {
                alert("ERRRORRRRRRRRRRR!!(" + status + ")");
            });
        };
        $scope.getSucursal();

        $scope.deleteSucursal = function(id) {
            if (confirm("Desea borrar el registro con id: " + $routeParams.id)) {
                $http({
                    method: "DELETE",
                    url: contextPath + "/api/SucursalBancaria/" + id
                }).success(function(data, status, headers, config) {
                    alert("Registro borrado");
                    window.location.assign("#/sucursalbancaria/sucursalesbancarias");
                    }).error(function(data, status, headers, config) {
                    alert("ERRRORRRRRRRRRRR!!(" + status + ")");
                });
            }
        };

    }]);

 app.controller("SucursalbancariaDetalleInsertController", ["$scope", "$http", function($scope, $http) {
        $scope.insertSucursal = function() {
            $http({
                method: "POST",
                data: $scope.sucursalBancaria,
                url: contextPath + "/api/SucursalBancaria/"
            }).success(function(data, status, headers, config) {
                alert("Registro insertado");
                window.location.assign("#/sucursalbancaria/sucursalesbancarias");
                }).error(function(data, status, headers, config) {
                alert("ERRRORRRRRRRRRRR!!(" + status + ")");
            });
        };
        //Le indicamos si es insert,update o delete
        $scope.action = "insert";
    }]);

 app.controller("SucursalbancariaDetalleUpdateController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {
        $scope.getSucursal = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria/" + $routeParams.id
            }).success(function(data, status, headers, config) {
                $scope.sucursalBancaria = data;
            }).error(function(data, status, headers, config) {
                alert("ERRRORRRRRRRRRRR!!(" + status + ")");
            });
        };
        $scope.getSucursal();
        //Le indicamos si es insert,update o delete
        $scope.action = "update";

        $scope.updateSucursal = function() {
            $http({
                method: "PUT",
                data: $scope.sucursalBancaria,
                url: contextPath + "/api/SucursalBancaria/"
            }).success(function(data, status, headers, config) {
                alert("Registro actualizado");
                window.location.assign("#/sucursalbancaria/sucursalesbancarias");
                }).error(function(data, status, headers, config) {
                alert("ERRRORRRRRRRRRRR!!(" + status + ")");
            });
        };
    }]);

    