//criar a aplicação
var app = angular.module('webapp', ['ionic'])
//inicializar a execução
app.run(function($ionicPlatform) {
  $ionicPlatform.ready(function() {
    if(window.cordova && window.cordova.plugins.Keyboard) {
      cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
    }
    if(window.StatusBar) {
      StatusBar.styleDefault();
    }
  });
})
//configurar o deep-linking
app.config(function($stateProvider, $urlRouterProvider){
  $stateProvider.state('home', {
    url: '/home',
    templateUrl: 'tpl/table.html',
    controller: 'homeController'
  })
  $stateProvider.state('form', {
    url: '/form',
    templateUrl: 'tpl/form.html',
    controller: 'formController'
  })
  $urlRouterProvider.otherwise('/home')
})
//criar o controle para a home
app.controller('homeController', ['$scope', '$state', 'studentModel', function($scope, $state, studentModel){
  $scope.students =  studentModel.listAll()
  $scope.append = function(){
    $state.go('form')
  }
}])
//criar o controle para a form
app.controller('formController', ['$scope', '$state', 'studentModel', function($scope, $state, studentModel){
  //inicializa o modelo
  $scope.student = {}
  $scope.save = function(){
    studentModel.append($scope.student, function(){
      $state.go('home')
    })
  }
}])
//criar o modelo de estudante
app.factory('studentModel', function($state){
  var students = []
  return {
    append: function(s, callback){
      console.info(JSON.stringify(s))
      students.push(s)
      console.info(JSON.stringify(students))
      callback()
    },
    listAll: function(){
      return students
    }
  }
})
