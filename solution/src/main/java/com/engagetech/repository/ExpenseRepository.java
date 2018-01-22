package com.engagetech.repository;

import com.engagetech.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The <code>ExpenseRepository</code> interface represents the Spring Data JPA repository for the
 * <code>Expense</code> entity
 */
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}