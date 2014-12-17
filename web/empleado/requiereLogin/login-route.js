app.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/login', {
        templateUrl: "requiereLogin/login.html",
        controller: "LoginController"
    });
}]);