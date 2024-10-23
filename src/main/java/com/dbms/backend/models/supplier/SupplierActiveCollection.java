package com.dbms.backend.models.supplier;

public record SupplierActiveCollection(int id, int supplier_id, int dress_id, int quality, int number_of_times_bought) {
    public SupplierActiveCollection {
        if (quality < 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
    }
    
}
