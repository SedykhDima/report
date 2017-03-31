/**
 * Created by dima on 31.03.17.
 */
var app = angular.module("reportApp");
app.controller("reportController", function ($scope, $http, $timeout) {
  var link = "http://localhost:8080/report";
  $scope.loadEmployee = function () {
    $http.get(link + "/get_all_employee").then(function (response) {
      $scope.employees = response.data;
    })
  };

  $scope.saveReport = function () {
    $http.get(link + "/save_report?value=" + $scope.value +
        "&employeeId=" + $scope.employee).then(function (response) {

      $scope.employee = {};
      $scope.value = {};
      $scope.message = "Отчет успешно сохранен";
      $scope.showMessage = true;
      $timeout(function(){
        $scope.showMessage = false;
      }, 10000);
    })
  }
});