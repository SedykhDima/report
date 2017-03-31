/**
 * Created by dima on 31.03.17.
 */
var delimiters = [
  {value : 30, name : "30 минут"},
  {value : 60, name : "1 час"},
  {value : 120, name : "2 часа"},
  {value : 180, name : "3 часа"}
];
var app = angular.module("reportApp");
app.controller("statisticController", function ($scope, $http) {
  var link = "http://localhost:8080/statistic"
  $scope.loadDepartments = function () {
    $http.get(link + "/get_all_department").then( function (response) {
      $scope.departments = response.data;
    })
  };

  $scope.getStat = function () {
    $http.get(link + "/get_statistic?departmentId=" + $scope.department +
        "&delimiter=" + $scope.delimiter).then( function (response) {
      $scope.statistics = response.data;
    })
  };

  $scope.delimiters = delimiters;
});