angular.module('expenseApp', [])
  .controller('ExpenseController', function($scope, $http) {
    var todoList = this;

//    todoList.expenses = [
//          {date:'2017-05-30', category:'Wellcome', amount:50},
//          {date:'2017-05-30', category:'WetMarket', amount:60}];


    $http.get("expense/list")
  .then(function(response) {
      $scope.todoList.expenses = response.data;
  });




    $scope.addExpense = function(){
		$scope.expense.push(newExpense);
		// Writing it to the server
		//
		var dataObj = {
				name : $scope.name,
				employees : $scope.employees,
				headoffice : $scope.headoffice
		};
		var res = $http.post('/savecompany_json', dataObj);
		res.success(function(data, status, headers, config) {
			$scope.message = data;
		});
		res.error(function(data, status, headers, config) {
			alert( "failure message: " + JSON.stringify({data: data}));
		});



    todoList.todos = [
      {text:'learn AngularJS', done:true},
      {text:'build an AngularJS app', done:false}];

    todoList.addTodo = function() {
      todoList.todos.push({text:todoList.todoText, done:false});
      todoList.todoText = '';
    };

    todoList.remaining = function() {
      var count = 0;
      angular.forEach(todoList.todos, function(todo) {
        count += todo.done ? 0 : 1;
      });
      return count;
    };

    todoList.archive = function() {
      var oldTodos = todoList.todos;
      todoList.todos = [];
      angular.forEach(oldTodos, function(todo) {
        if (!todo.done) todoList.todos.push(todo);
      });
    };
  });