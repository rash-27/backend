package com.dbms.backend.models.transaction;

import java.time.LocalDate;

public record CustomerTransaction(int id, int customer_id, LocalDate transaction_date, double amount) {
    public CustomerTransaction {
        if (transaction_date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
    }
}
