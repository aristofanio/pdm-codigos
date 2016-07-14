// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
angular.module('starter', ['ionic'])

.run(function($ionicPlatform) {
  $ionicPlatform.ready(function() {
    // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
    // for form inputs)
    if(window.cordova && window.cordova.plugins.Keyboard) {
      cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
    }
    if(window.StatusBar) {
      StatusBar.styleDefault();
    }
  });
})
.config(function($stateProvider, $httpProvider, $urlRouterProvider) {
  //
  $httpProvider.defaults.useXDomain = true;
  $httpProvider.defaults.withCredentials = true;
  delete $httpProvider.defaults.headers.common['X-Requested-With'];
})
.controller("personController", ["$scope", "$http", function($scope, $http){
  //
  var url = "http://192.168.137.86/php" + 
    "/ag-upmarketing-scholarapp/dev" + 
    "/appcollege-server/webservice.php?r=agenda&a=listlatest"
  //
  $http.get(url).then(function(response){
    $scope.messages = response.data.data
  })  

}])
