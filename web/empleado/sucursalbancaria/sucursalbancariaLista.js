 app.controller("SucursalbancariaListaController", ["$location","$scope", "$http", function($location,$scope, $http){
        $scope.findAll = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria"
            }).success(function(data, status, headers, config) {
                $scope.sucursalesBancarias = data;
                }).error(function(data, status, headers, config) {
                 $location.url("/loginrequired");
            });
        };
        
        //Cargamos el findall
        $scope.findAll();
    }]);