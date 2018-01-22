package com.engagetech.service;

import com.engagetech.model.Expense;
import com.engagetech.repository.ExpenseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * The <code>ExpenseServiceImpl</code> class implements the <code>ExpenseService</code> interface
 * and it is the Spring bean component which is responsible for all persistence-related functionalities
 * pertaining to the <code>Expense</code> class.
 */

@Slf4j
@Service("expenseService")
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // Get all expenses
    @Override
    public Set<Expense> getExpenses() {
        Set<Expense> expenses = new HashSet<>();
        log.info("Retrieving all expenses from the database");
        expenseRepository.findAll().iterator().forEachRemaining(expenses::add);
        return expenses;
    }

    // Get an expense based on id - NOTE: this is not used for the coding challenge
    @Override
    public Expense findById(Long id) {
        return expenseRepository.findOne(id);
    }

    // Save an expense
    @Override
    public void saveExpense(Expense expense) {
        log.info("Saving an expense to the database: " + expense);
        expenseRepository.save(expense);
    }

    // Update an expense - NOTE: this is not used for the coding challenge
    @Override
    public void updateExpense(Expense expense) {
        saveExpense(expense);
    }

    // Delete an expense - NOTE: this is not used for the coding challenge
    @Override
    public void deleteExpense(Long id) {
        expenseRepository.delete(id);
    }

    // Delete all expenses - NOTE: this is not used for the coding challenge
    @Override
    public void deleteAllExpenses() {
        expenseRepository.deleteAll();
    }

    // Check to see if an expense exists - NOTE: this is not used for the coding challenge
    @Override
    public boolean isExpenseExists(Expense expense) {
        return findById(expense.getId()) != null;
    }
}
