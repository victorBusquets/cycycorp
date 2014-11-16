app.config(['$routeProvider', function($routeProvider) {

        $routeProvider.when('/cuenta/cuentas', {
            templateUrl: "cuenta/cuenta-list.html",
            controller: "CuentaListController"
        });

        $routeProvider.when('/cuenta/Update/:id', {
            templateUrl: "cuenta/cuenta-detail.html",
            controller: "CuentaDetailModificarController"
        });
        $routeProvider.when('/cuenta/Delete/:id', {
            templateUrl: "cuenta/cuenta-detail.html",
            controller: "CuentaDetailDeleteController"
        });
                $routeProvider.when('/cuenta/Insert', {
            templateUrl: "cuenta/cuenta-detail.html",
            controller: "CuentaDetailInsertarController"
        });
        
    }]);