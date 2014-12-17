app.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/login', {
        templateUrl: "login/login.html",
        controller: "LoginController"
    });
    
    $routeProvider.when('/logout', {
        templateUrl:"main/main.html",
        controller: "LogoutController"
    });
}]);