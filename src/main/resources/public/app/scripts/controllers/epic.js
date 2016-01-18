'use strict';

/**
 * @ngdoc function
 * @name taaTaskManagerApp.controller:EpicCtrl
 * @description
 * # EpicCtrl
 * Controller of the taaTaskManagerApp
 */
angular.module('taaTaskManagerApp')
  .controller('EpicCtrl', function ($http) {

    this.items = [];

    $http.get('/api/epic',
        {
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(function success(response){
            $scope.items = response;
        })
  });
