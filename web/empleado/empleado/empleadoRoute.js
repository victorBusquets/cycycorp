
app.config(['$routeProvider',function($routeProvider) { 
  

  $routeProvider.when('/empleado/empleados', {
    templateUrl: "empleado/empleadoLista.html",
    controller: "EmpleadoListaController"
  });
  
  $routeProvider.when('/empleado/detalles', { //INSERT
    templateUrl: "empleado/empleadoDetalles.html",
    controller: "EmpleadoDetallesInsertController"
  });
    
  $routeProvider.when('/empleado/detalles/:id', { //UPDATE
    templateUrl: "empleado/empleadoDetalles.html",
    controller: "EmpleadoDetallesUpdateController"
  });
  

}]);

