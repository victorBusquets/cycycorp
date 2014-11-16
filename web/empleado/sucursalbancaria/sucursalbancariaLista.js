 app.controller("SucursalbancariaListaController", ["$scope", "$http", function($scope, $http){
        $scope.findAll = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria"
            }).success(function(data, status, headers, config) {
                $scope.sucursalesBancarias = data;
                }).error(function(data, status, headers, config) {
                alert("ERROR!!(" + status + ")");
            });
        };
        
        //Cargamos el findall
        $scope.findAll();
    }]);