package com.engagetech.utils;

import com.engagetech.model.Expense;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * The <code>ExpenseUpdateListener</code> class calculates the VAT on the <code>Expense</code> object
 * before it is persisted to the database.
 */

public class ExpenseUpdateListener {

    @PreUpdate
    @PrePersist
    public void setLastUpdate(Expense expense) {
        expense.setVat(expense.getAmount() - expense.getAmount()/1.2);
    }
}
