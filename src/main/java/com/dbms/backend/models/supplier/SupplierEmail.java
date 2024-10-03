package com.dbms.backend.models.supplier;

public record SupplierEmail(int id, int supplier_id, String email) {
    public SupplierEmail {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
    }
    
}
