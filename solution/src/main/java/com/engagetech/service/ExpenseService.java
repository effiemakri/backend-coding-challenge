package com.engagetech.service;

import com.engagetech.model.Expense;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

/**
 * The <code>ExpenseService</code> interface represents the Service for the <code>Expense</code> entity.
 * It is responsible for all functionalities related to the persistence of the <code>Expense</code> entity
 */
public interface ExpenseService {
    Set<Expense> getExpenses();
    Expense findById(Long id);
    Expense saveExpense(Expense expense);
    void updateExpense(Expense expense);
    void deleteExpense(Long id);
    void deleteAllExpenses();
    boolean isExpenseExists(Expense expense);
}
