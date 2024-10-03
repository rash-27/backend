package com.dbms.backend.models.supplier;

public record SupplierDetails(int id, String name, String address) {
    public SupplierDetails {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
    }
}
