package com.engagetech.service;

import com.engagetech.model.Expense;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
    public void shouldSaveExpenseBeCalled_whenSaveExpenseIsCalled() {

        // as the saveExpense method of ExpenseService returns a void, Mockito's doNothing() is used.
        Mockito.doNothing().when(service).saveExpense(any(Expense.class));
        
        // call the saveExpense method once, and make sure that it was called properly
        service.saveExpense(new Expense());
        verify(service, times(1)).saveExpense(new Expense());
    }
}