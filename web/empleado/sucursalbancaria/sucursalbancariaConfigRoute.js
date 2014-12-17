app.config(['$routeProvider',function($routeProvider) {
   
  $routeProvider.when('/sucursalbancaria/sucursalesbancarias', {
    templateUrl: "sucursalbancaria/sucursalbancariaLista.html",
    controller: "SucursalbancariaListaController"
  });
  
    $routeProvider.when('/sucursalbancaria/insert', {
    templateUrl: "sucursalbancaria/sucursalbancariaDetalle.html",
    controller: "SucursalbancariaDetalleInsertController"
  });
  
      $routeProvider.when('/sucursalbancaria/update/:id', {
    templateUrl: "sucursalbancaria/sucursalbancariaDetalle.html",
    controller: "SucursalbancariaDetalleUpdateController"
  });
  
      $routeProvider.when('/sucursalbancaria/delete/:id', {
    templateUrl: "sucursalbancaria/sucursalbancariaDelete.html",
    controller: "SucursalbancariaDetalleDeleteController"
  });
}]);

