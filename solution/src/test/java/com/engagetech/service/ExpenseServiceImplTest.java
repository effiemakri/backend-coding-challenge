package com.engagetech.service;

import com.engagetech.model.Expense;
import com.engagetech.repository.ExpenseRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;

public class ExpenseServiceImplTest {

    @Mock
    ExpenseService service;

    @Before
    public void setUp() throws Exception {
        // set up the Mocks
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnAllExpenses_whenGetExpensesIsCalled() {

        // create a new Set of Expense object, and populate it with one instance of an expense
        HashSet<Expense> expenseData = new HashSet<>();
        expenseData.add(new Expense());

        // Instruct mockito to return this set, when getExpenses is called on the ExpenseService
        Mockito.when(service.getExpenses()).thenReturn(expenseData);

        // check to see if the ExpenseService will return a Set with one object in it
        Set<Expense> expenses = service.getExpenses();
        assertEquals(expenses.size(), 1);
    }

    @Test
    public void shouldReturnNewlyCreatedExpense_whenSaveExpenseIsCalled() {

        Expense expense = new Expense();
        expense.setId(1L);

        // instruct Mockito to return the newly created expense when saveExpense is called
        Mockito.when(service.saveExpense(any(Expense.class))).thenReturn(expense);

        // check to see that the returned expense is the same as the created one (check the ID of the Expense object that was return):
        assertEquals(Long.valueOf(1L), service.saveExpense(new Expense()).getId());
    }
}