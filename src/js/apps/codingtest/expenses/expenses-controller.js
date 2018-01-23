"use strict";

/******************************************************************************************

Expenses controller

******************************************************************************************/

var app = angular.module("expenses.controller", []);

app.controller("ctrlExpenses", ["$rootScope", "$scope", "config", "restalchemy", "currencyService", function ExpensesCtrl($rootScope, $scope, $config, $restalchemy, currencyService) {
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

			// check if EUR has been input:
			var amount = $scope.newExpense.amount.toUpperCase();
			if (amount.includes('EUR')) {
				amount = clearAmount(amount);
				console.log('after cleaning the amount ....' + amount);
				var ratePromise = currencyService.getRate($scope.newExpense.date);
				ratePromise.then(function(rate) {
					// Convert the amount to GBP, and round off to two decimals
					console.log(' Before conversion: amount and rate ' + amount + ' ' + rate);
					$scope.newExpense.amount = Math.round((amount * rate) * 100)/100;
					// Calculate the VAT:
					$scope.newExpense.vat = $scope.newExpense.amount * (1 - 1/1.2);
					console.log(' new expense ... in GBP ' + $scope.newExpense.amount + " and vat " + $scope.newExpense.vat);
					// Post the converted expense via REST:
					restExpenses.post($scope.newExpense).then(function() {
						$scope.expenses.push($scope.newExpense);
						loadExpenses();
					});
				});
			}
			else {
				// Save the expense (GBP amount).
				// Calculate the VAT:
				$scope.newExpense.vat = $scope.newExpense.amount * (1 - 1/1.2);
				// Post the expense via REST
				restExpenses.post($scope.newExpense).then(function() {
					// Ensure that the newly-created expense is displayed on the page immediately
					$scope.expenses.push($scope.newExpense);
					// Reload new expenses list
					loadExpenses();
				});
			}
		}
	};

	$scope.clearExpense = function() {
		$scope.newExpense = {};
	};

	// Retrieve the number-only part from the amount
	var clearAmount = function(amount) {
		// Convert the amount to non-continental decimal
		var amountClean = amount.replace(',', '.');
		// Keep the number portion of the amount
		amountClean = amountClean.slice(0, amount.indexOf('EUR')).trim();
		return amountClean;
	}

	// Initialise scope variables
	loadExpenses();
	$scope.clearExpense();
}]);

// Service for retrieving the exchange rate
// Note: it has been included in here so as not to interfere too much with the FE code.
app.service('currencyService', ["$http", function($http) {

	// Retrieve the GBP exchange rate for EUR for the particular date
	this.getRate = function(date) {
		date = convertDate(date);
		var endpoint = "https://api.fixer.io/" + date + "?base=EUR&symbols=GBP";
		return $http.get(endpoint).then(function(result) {
			return result.data.rates.GBP;
		});
	};

	// Convert the date to the desired format
	var convertDate = function(date) {
		return date.split('/').reverse().join('-');
	}

}]);
