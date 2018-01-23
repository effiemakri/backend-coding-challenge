package com.engagetech.controller;

import com.engagetech.model.Expense;
import com.engagetech.service.ExpenseServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Matchers.any;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ExpenseControllerTest {

    @Mock
    ExpenseServiceImpl service;

    ExpenseController controller;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        // Inialise the Mocks:
        MockitoAnnotations.initMocks(this);
        controller = new ExpenseController(service);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    // Test for the getExpenses (GET)
    @Test
    public void shoudlReturnAllExpensesAndOKStatus_whenGetExpensesIsCalled() throws Exception {
        Set<Expense> expenses = new HashSet<>();
        expenses.add(new Expense());

        // Instruct Mockito to return the exenses set when getExpenses() is called
        Mockito.when(service.getExpenses()).thenReturn(expenses);

        // test that when GET request is called and expenses are retrieved, HTTP Status OK is returned
        mockMvc.perform(get("/app/expenses"))
                .andExpect(status().isOk());

        // check that it is called once.
        Mockito.verify(service, Mockito.times(1)).getExpenses();
    }

    // Test for the saveExpense (POST)
    @Test
    public void shouldReturnExpenseAndOKStatus_whenSaveExpenseIsCalled() throws Exception {

        Expense expense = new Expense();

        // Create a JSON representation of the Expense object, to be sent on POST
        final String EXPENSE_REQUEST = "{" +
                "\"date\" : " + 1516226400000L + ", " +
                "\"amount\" : " + 120 + ", " +
                "\"vat\" : " + 20 + ", " +
                "\"reason\" : \"Some reason\" }";

        System.out.println("EXPENSE_REQUEST = " + EXPENSE_REQUEST);

        // Instruct Mockito to return this newly created Expense object when saveExpense is called
        Mockito.when(service.saveExpense(any(Expense.class))).thenReturn(expense);

        // Test that when POST request is called and expenses are retrieved, HTTP Status CREATED is returned
        mockMvc.perform(post("/app/expenses")
                .content(EXPENSE_REQUEST)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isCreated());
    }

}