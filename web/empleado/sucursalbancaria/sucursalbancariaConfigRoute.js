app.config(['$routeProvider',function($routeProvider) {
   
  $routeProvider.when('/SucursalBancaria/SucursalesBancarias', {
    templateUrl: "sucursalbancaria/sucursalbancariaLista.html",
    controller: "SucursalbancariaListaController"
  });
  
    $routeProvider.when('/SucursalBancaria/Insert', {
    templateUrl: "sucursalbancaria/sucursalbancariaDetalle.html",
    controller: "SucursalbancariaDetalleInsertController"
  });
  
      $routeProvider.when('/SucursalBancaria/Update/:id', {
    templateUrl: "sucursalbancaria/sucursalbancariaDetalle.html",
    controller: "SucursalbancariaDetalleUpdateController"
  });
  
      $routeProvider.when('/SucursalBancaria/Delete/:id', {
    templateUrl: "sucursalbancaria/sucursalbancariaDelete.html",
    controller: "SucursalbancariaDetalleDeleteController"
  });
}]);

