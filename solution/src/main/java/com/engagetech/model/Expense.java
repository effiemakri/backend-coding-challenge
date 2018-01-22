package com.engagetech.model;

import com.engagetech.utils.ExpenseUpdateListener;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * The <code>Expense</code> class represents the model entity for the Expense object
 */
@Data
@Entity
@Table(name = "expenses")
@EntityListeners(ExpenseUpdateListener.class)
public class Expense implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "date")
    private Date date;

    @NotNull
    @Column(name = "amount")
    private double amount;

    @NotNull
    @Column(name = "vat")
    private double vat;

    @Lob
    @NotNull
    @Column(name = "reason")
    private String reason;
}
