var db = null
//criar a aplicação
var app = angular.module('webapp', ['ionic', 'ngCordova'])
//inicializar a execução
app.run(function($ionicPlatform, $cordovaSQLite) {
  $ionicPlatform.ready(function() {
    if(window.cordova && window.cordova.plugins.Keyboard) {
      cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
    }
    if(window.StatusBar) {
      StatusBar.styleDefault();
    }
    //criando o banco de dados na primeira vez se não existir
    //var db = $cordovaSQLite.openDB("my.db");
    db = window.sqlitePlugin.openDatabase({name: "my.db", androidDatabaseImplementation: 2, androidLockWorkaround: 1});
    //$cordovaSQLite.execute(db, 
    //   "DROP TABLE student "
    //);
    $cordovaSQLite.execute(db, 
       "CREATE TABLE IF NOT EXISTS student (" +
            "code integer primary key, " +
            "name text, " + 
            "cpf text " +
       ")"
    );
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
  //
  var listAll = function(){
    studentModel.listAll(function(s){
      $scope.students = s;
    })
  }
  //
  $scope.$on('$ionicView.enter', function() {
    setTimeout(function(){
      listAll()//listar estudantes
    }, 2000)
  });
  //
  $scope.append = function(){
    $state.go('form')// VAI PARA TELA DE FORMULÁRIO
  }
  //
  $scope.delete = function(code){
    //
    var callback = function(){
      listAll()//listar estudantes
    }
    //executar a função remove
    //do modelo studentModel
    studentModel.remove(code, callback)
  }
}])
//criar o controle para a form
app.controller('formController', ['$scope', '$state', 'studentModel', function($scope, $state, studentModel){
  //inicializa o modelo
  $scope.student = {}
  $scope.save = function(){
    studentModel.append($scope.student, function(){
      $state.go('home', {}, {reload: true})
    })
  }
}])
//criar o modelo de estudante
app.factory('studentModel', function($state, $cordovaSQLite){
  //
  var SQL_INSERT = "INSERT INTO student(code, name, cpf) VALUES (?,?,?)"
  var SQL_SELECT = "SELECT code, name, cpf FROM student"
  var SQL_DELETE = "DELETE FROM student WHERE code = ?"
  //
  return {
    append: function(s, callback){
      $cordovaSQLite.execute(db, SQL_INSERT, [s.code, s.name, s.cpf]).then(function(res) {
        callback()
      }, function (err) {
        console.error(err);
      })
    },
    listAll: function(callback){
      $cordovaSQLite.execute(db, SQL_SELECT, []).then(function(res) {
        result = []
        if(res.rows.length > 0) {            
            for (var i = 0; i < res.rows.length; i++){
              result.push(res.rows.item(i))
            }
        } else {
            console.log("No results found");
        }
        callback(result)
      }, function (err) {
          console.error(err);
      });
    },
    remove: function(code, callback){
      $cordovaSQLite.execute(db, SQL_DELETE, [code]).then(function(res) {
        callback()
      }, function (err) {
          console.error(err);
      });
    }
  }
})
