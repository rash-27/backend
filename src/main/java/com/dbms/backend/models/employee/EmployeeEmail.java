package com.dbms.backend.models.employee;

public record EmployeeEmail(int id, int employee_id, String email) {
    public EmployeeEmail {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
    }
    
}
