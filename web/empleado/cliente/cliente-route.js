
app.config(['$routeProvider', function($routeProvider) {

        $routeProvider.when('/cliente/clientes', {
            templateUrl: "cliente/cliente-list.html",
            controller: "ClienteListController"
        });
        
        $routeProvider.when('/cliente/Update/:id', {
            templateUrl: "cliente/cliente-detail.html",
            controller: "ClienteDetailModificarController"
        });
        $routeProvider.when('/cliente/Delete/:id', {
            templateUrl: "cliente/cliente-detail.html",
            controller: "ClienteDetailDeleteController"
        });

        $routeProvider.when('/cliente/Insert', {
            templateUrl: "cliente/cliente-detail.html",
            controller: "ClienteDetailInsertController"
        });

    }]);
