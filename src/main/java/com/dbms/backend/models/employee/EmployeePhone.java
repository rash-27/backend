package com.dbms.backend.models.employee;

public record EmployeePhone (int id, int employee_id, String phone) {
    public EmployeePhone {
        if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException("Phone cannot be null or empty");
        }
    }
    
}
