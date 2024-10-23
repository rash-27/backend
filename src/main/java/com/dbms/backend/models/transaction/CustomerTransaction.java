package com.dbms.backend.models.transaction;

import java.time.LocalDate;
import java.util.List;
import com.dbms.backend.models.stock.StockDescription;


public record CustomerTransaction(int id, int customer_id, LocalDate transaction_date, double amount, List<StockDescription> StockDescription) {
    public CustomerTransaction {
        if (transaction_date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (StockDescription == null || StockDescription.isEmpty()) {
            throw new IllegalArgumentException("StockDescription cannot be null");
        }
        if(amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
    }
}
