angular.module('expenseApp', [])
  .controller('expenseListController', function($scope, $http) {
    var expenseList = this;
    expenseList.expenses = [
      {date:'2016-05-01', category:'Wellcome', amount:10},
     {date:'2017-05-04', category:'Wet Market', amount:310}];

    expenseList.addExpense = function() {
      expenseList.expenses.push({date:expenseList.date, category:expenseList.category, amount:expenseList.amount});
      expenseList.date = '';
      expenseList.category='';
      expenseList.amount=0;
    };

  //  expenseList.listExpense =function($scope, $http) {
   //     $http.get("expense/list").then(function(response) {
   //        $scope.expenses = response.data.records;
        };
    //};

//    todoList.remaining = function() {
//      var count = 0;
//      angular.forEach(todoList.todos, function(todo) {
//        count += todo.done ? 0 : 1;
//      });
//      return count;
//    };
//
//    todoList.archive = function() {
//      var oldTodos = todoList.todos;
//      todoList.todos = [];
//      angular.forEach(oldTodos, function(todo) {
//        if (!todo.done) todoList.todos.push(todo);
//      });
//    };
  });