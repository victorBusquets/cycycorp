var app = angular.module("app", ['ngRoute']);

app.run(function($rootScope, $http) {
    $rootScope.logcheck = function() {
        $http({
            method: "GET",
            url: contextPath + "/api/session/empleado"
        }).success(function(data, status, headers, config) {
            $rootScope.empleado = data;
        }).error(function(data, status, headers, config) {
            $rootScope.empleado = null;
        });
    };
    $rootScope.logcheck();
    
    $rootScope.logout = function() {
        $http({
            method: "DELETE",
            url: contextPath + "/api/session/empleado"
        }).success(function(data, status, headers, config) {
            $rootScope.empleado = null;
            window.location.assign("#/");
        }).error(function(data, status, headers, config) {
            alert("Error: " + status);
        });
    };
});

