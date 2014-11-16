app.config(['$routeProvider', function($routeProvider) {

        $routeProvider.when('/movimientobancario/MovimientoBancarios', {
            templateUrl: "movimientobancario/movimientobancario-list.html",
            controller: "MovimientoBancarioListController"
        });

        $routeProvider.when('/movimientobancario/Insert', {
            templateUrl: "movimientobancario/movimientobancario-detail.html",
            controller: "MovimientoBancarioDetailInsertarController"
        });

        $routeProvider.when('/movimientobancario/Update/:id', {
            templateUrl: "movimientobancario/movimientobancario-detail.html",
            controller: "MovimientoBancarioDetailModificarController"
        });
        $routeProvider.when('/movimientobancario/Delete/:id', {
            templateUrl: "movimientobancario/movimientobancario-detail.html",
            controller: "MovimientoBancarioDetailDeleteController"
        });
        
    }]);