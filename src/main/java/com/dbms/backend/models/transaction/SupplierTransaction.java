package com.dbms.backend.models.transaction;

import java.time.LocalDate;
import com.dbms.backend.models.stock.StockDescriptionSupplier;

import java.util.List;

public record SupplierTransaction(int id, int supplier_id, double amount, LocalDate transaction_date, List<StockDescriptionSupplier> StockDescriptionSupplier) {
    public SupplierTransaction {
        if (transaction_date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (StockDescriptionSupplier == null || StockDescriptionSupplier.isEmpty()) {
            throw new IllegalArgumentException("StockDescription cannot be null");
        }
        if(amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
    }
    
}
