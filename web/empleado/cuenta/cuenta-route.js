app.config(['$routeProvider', function($routeProvider) {

        $routeProvider.when('/cuenta/cuentas', {
            templateUrl: "cuenta/cuenta-list.html",
            controller: "CuentaListController"
        });

        $routeProvider.when('/cuenta/update/:id', {
            templateUrl: "cuenta/cuenta-detail.html",
            controller: "CuentaDetailModificarController"
        });
        $routeProvider.when('/cuenta/delete/:id', {
            templateUrl: "cuenta/cuenta-detail.html",
            controller: "CuentaDetailDeleteController"
        });
                $routeProvider.when('/cuenta/insert', {
            templateUrl: "cuenta/cuenta-detail.html",
            controller: "CuentaDetailInsertarController"
        });
        
    }]);