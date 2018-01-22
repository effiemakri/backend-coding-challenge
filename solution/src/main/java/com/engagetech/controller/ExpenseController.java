package com.engagetech.controller;

import com.engagetech.model.Expense;
import com.engagetech.service.ExpenseService;
import com.engagetech.service.ExpenseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * The <code>ExpenseController</code> class exposes the REST endpoints for retrieving all <code>Expense</code> objects
 * from the database (GET) and saving an <code>Expense</code> object to the database (POST)
 */

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/app")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseServiceImpl expenseService) {
        this.expenseService = expenseService;
    }

    // Get all expenses
    @GetMapping(value = "/expenses")
    public ResponseEntity<Set<Expense>> getExpenses() {

        log.info(" ------------------ GETTING THE DATA FROM THE DATEBASE -----------------");
        Set<Expense> expenses = expenseService.getExpenses();
        if (expenses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    // Save an expense
    @PostMapping(value = "/expenses")
    public ResponseEntity<?> saveExpense(@RequestBody Expense expense) {

        log.info(" ------------------ SAVING THE DATA TO THE DATEBASE -----------------");
        expenseService.saveExpense(expense);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
