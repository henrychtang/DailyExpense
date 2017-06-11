angular.module('expenseApp', [])
  .controller('ExpenseController', function($scope, $http) {
    var todoList = this;

//    todoList.expenses = [
//          {date:'2017-05-30', category:'Wellcome', amount:50},
//          {date:'2017-05-30', category:'WetMarket', amount:60}];


    $http.get("expense/list")
  .then(function(response) {
      $scope.todoList.expenses = response.data;
      console.log(todoList.expenses);
  });



    todoList.category="Market";
    todoList.addExpense = function(){
        console.log("addExpense called");
    	var newExpense = {

				date : todoList.date.toISOString(),
				category : todoList.category,
				amount : todoList.amount+""
		};
		console.log(newExpense);

		var res = $http.post('expense/add_json', newExpense).
		then(function onSuccess(response) {
			$scope.message = response.data;
			console.log("refreshing");
            todoList.refreshExpenseList();
            console.log("done!");
		}).
		catch(function onError(response) {
			alert( "failure message: " + JSON.stringify({data: response.data}));
		});
	};

    //refreshExpenseList
     todoList.refreshExpenseList=function(){
         $http.get("expense/list")
           .then(function(response) {
               $scope.todoList.expenses = response.data;
               console.log(todoList.expenses);
           }).
           catch(function onError(response) {
           			alert( "failure message: " + JSON.stringify({data: response.data}));
           		});
     };

    //getTotal
    todoList.getTotal=function(){
    var total = 0;
    if(todoList.expenses!=null) {
        for(var i = 0; i < todoList.expenses.length; i++){
            var expense = todoList.expenses[i];
            total += Number(expense.amount);
        }
        }
        return total;
    };
    //deleteExpense
    todoList.deleteExpense = function(recordId){
        console.log("deleteExpense called");
    	var newExpense = {
    	        "id" : recordId
		};
		console.log(newExpense);

		var res = $http.post('expense/delete_json', newExpense).
		then(function onSuccess(response) {
			$scope.message = response.data;
			console.log($scope.message);
			console.log("refreshing list");
            todoList.refreshExpenseList();
            console.log("done!");
		}).
		catch(function onError(response) {
			alert( "failure message: " + JSON.stringify({data: response.data}));
		});


	};

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