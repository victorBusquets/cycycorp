app.config(['$routeProvider',function($routeProvider) {
   
  $routeProvider.when('/loginrequired', {
    templateUrl: "requiereLogin/loginRequired.html",
    controller: ""
  });

}]);
