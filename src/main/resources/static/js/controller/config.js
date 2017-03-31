/**
 * Created by dima on 31.03.17.
 */
var app = angular.module("reportApp", ["ngRoute"]);
app.config(function($routeProvider) {
  $routeProvider
  .when("/report", {
    templateUrl : "pages/report.html"
  })
  .when("/statistic", {
    templateUrl : "pages/statistic.html"
  });
});

/*app.config(function($locationProvider) {
  $locationProvider.hashPrefix('');
});*/

