angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    //$http.get('http://rest-service.guides.spring.io/greeting').
            $http.get('greeting').
                    then(function(response) {
            $scope.greeting = response.data;
        });


});
