package com.dbms.backend.models.stock;

import java.time.LocalDate;

public record StockDescription(int id, int dress_id, int available_quantity, LocalDate purchase_date, double purchase_price, double selling_price, int damaged_quantity) {

    public StockDescription {
        if (purchase_date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        if (purchase_price < 0) {
            throw new IllegalArgumentException("Purchase price cannot be negative");
        }
        if (selling_price < 0) {
            throw new IllegalArgumentException("Selling price cannot be negative");
        }
        if (available_quantity < 0) {
            throw new IllegalArgumentException("Available quantity cannot be negative");
        }
        if (damaged_quantity < 0) {
            throw new IllegalArgumentException("Damaged quantity cannot be negative");
        }
    }
}
