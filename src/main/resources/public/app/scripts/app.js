'use strict';

/**
 * @ngdoc overview
 * @name taaTaskManagerApp
 * @description
 * # taaTaskManagerApp
 *
 * Main module of the application.
 */
angular
  .module('taaTaskManagerApp', [
    'ngAnimate',
    'ngCookies',
    'ngMessages',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider, $httpProvider) {
    $httpProvider.defaults.headers.common['Content-Type'] = 'application/json; charset=utf-8';

    $routeProvider
      .when('/', {
        templateUrl: 'views/summary.html',
        controller: 'SummaryCtrl',
        controllerAs: 'summary'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
