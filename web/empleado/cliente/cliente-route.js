
app.config(['$routeProvider', function($routeProvider) {

        $routeProvider.when('/cliente/clientes', {
            templateUrl: "cliente/cliente-list.html",
            controller: "ClienteListController"
        });
        
        $routeProvider.when('/cliente/update/:id', {
            templateUrl: "cliente/cliente-detail.html",
            controller: "ClienteDetailModificarController"
        });
        $routeProvider.when('/cliente/delete/:id', {
            templateUrl: "cliente/cliente-detail.html",
            controller: "ClienteDetailDeleteController"
        });

        $routeProvider.when('/cliente/insert', {
            templateUrl: "cliente/cliente-detail.html",
            controller: "ClienteDetailInsertController"
        });

    }]);
