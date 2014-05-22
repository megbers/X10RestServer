var x10Client = angular.module("x10Client", ['ngRoute']);


x10Client.controller("x10ComponentList",  ['$scope', '$http', '$location', 'ComponentStore', function($scope, $http, $location, ComponentStore) {

    $http.get('/X10RestServer/rest/manager/AllComponents').success(function(data) {
        $scope.components = data;
    });

    $scope.selectComponent = function(component) {
        $scope.toggleModal(component);
    };

    $scope.deleteComponent = function(component) {
        ComponentStore.component = component;
        $location.path('/DeleteComponent');
    };

    $scope.sendCommand = function(component, command) {
        var commandUrl = '/X10RestServer/rest/light/' + command + '/' + component.houseCode + '/' + component.unitCode;
        $http.get(commandUrl).success(function(data) {
            if(data.errorMessage) {
                alert('Error\n' + data.errorMessage);
            }
            $scope.toggleModal({});
        });
    };

    //For the modal window
    $scope.modalShown = false;
    $scope.selectedComponent = {};
    $scope.toggleModal = function(component) {
        $scope.modalShown = !$scope.modalShown;
        $scope.selectedComponent = component;
    };
}]);

x10Client.controller("x10ComponentAdd",  ['$scope', '$http', '$location', function($scope, $http, $location) {
    $scope.component = {};

    //TODO Make this an HTTP POST
    $scope.addComponent = function() {
        var houseCode = $scope.component.houseCode;
        var unitCode = $scope.component.unitCode;
        var commonName = encodeURIComponent($scope.component.commonName);
        var type = $scope.component.type;
        var loadUrl = '/X10RestServer/rest/manager/AddComponent/'+ houseCode + '/' + unitCode + '/' + commonName + '/' + type;
        $http.get(loadUrl).success(function(data) {
            $location.path('/ShowAllComponents');
        });
    };
}]);

x10Client.controller("x10ComponentDelete", ['$scope', '$http', '$location', 'ComponentStore', function($scope, $http, $location, ComponentStore) {
    $scope.component = ComponentStore.component;

    //TODO Make this an HTTP DELETE
    $scope.deleteComponent = function() {
        var loadUrl = '/X10RestServer/rest/manager/DeleteComponent/' + $scope.component.id;
        $http.get(loadUrl).success(function(data) {
            $location.path('/ShowAllComponents');
        });
    }
}]);

x10Client.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/AddNewComponent', {
                templateUrl: 'html/component_add.html',
                controller: 'x10ComponentAdd'
            }).
            when('/ShowAllComponents', {
                templateUrl: 'html/component_list.html',
                controller: 'x10ComponentList'
            }).
            when('/DeleteComponent', {
                templateUrl: 'html/component_delete.html',
                controller: 'x10ComponentDelete'
            }).
            otherwise({
                redirectTo: '/ShowAllComponents'
            });
    }
]);

x10Client.directive('modalDialog', function() {
    return {
        restrict: 'E',
        scope: {
            show: '='
        },
        replace: true, // Replace with the template below
        transclude: true, // we want to insert custom content inside the directive
        link: function(scope, element, attrs) {
            scope.dialogStyle = {};
            if (attrs.width)
                scope.dialogStyle.width = attrs.width;
            if (attrs.height)
                scope.dialogStyle.height = attrs.height;
            scope.hideModal = function() {
                scope.show = false;
            };
        },
        templateUrl: 'html/simple_modal.html'
    };
});

x10Client.factory("ComponentStore", function() {
    return {};
});