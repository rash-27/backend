package com.dbms.backend.models.supplier;

public record SupplierPhone(int id, int supplier_id, String phone) {
    public SupplierPhone {
        if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException("Phone cannot be null or empty");
        }
    }
    
}
