"use strict";

/******************************************************************************************

Expenses controller

******************************************************************************************/

var app = angular.module("expenses.controller", []);

app.controller("ctrlExpenses", ["$rootScope", "$scope", "config", "restalchemy", function ExpensesCtrl($rootScope, $scope, $config, $restalchemy) {
	// Update the headings
	$rootScope.mainTitle = "Expenses";
	$rootScope.mainHeading = "Expenses";

	// Update the tab sections
	$rootScope.selectTabSection("expenses", 0);

	var restExpenses = $restalchemy.init({ root: $config.apiroot }).at("expenses");
	$scope.expenses = [];

	$scope.dateOptions = {
		changeMonth: true,
		changeYear: true,
		dateFormat: "dd/mm/yy"
	};

	var loadExpenses = function() {
		// Retrieve a list of expenses via REST
		restExpenses.get().then(function(expenses) {
			$scope.expenses = expenses;
		});
		$scope.clearExpense();
	}

	$scope.saveExpense = function() {
		if ($scope.expensesform.$valid) {
			// calculate the VAT:
			$scope.newExpense.vat = $scope.newExpense.amount * (1 - 1/1.2);
			// Post the expense via REST
			restExpenses.post($scope.newExpense).then(function() {
				// ensure that the newly-created expense is displayed on the page immediately
				$scope.expenses.push($scope.newExpense);
				// Reload new expenses list
				// loadExpenses();
			});
		}
	};

	$scope.clearExpense = function() {
		$scope.newExpense = {};
	};

	// Initialise scope variables
	loadExpenses();
	$scope.clearExpense();
}]);
