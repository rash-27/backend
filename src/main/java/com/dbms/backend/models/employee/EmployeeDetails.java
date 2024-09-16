package com.dbms.backend.models.employee;

import java.time.LocalDate;

public record EmployeeDetails(int emp_id, String name, String role, String address, LocalDate join_date, double salary) {
    public EmployeeDetails {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (role == null || role.isBlank()) {
            throw new IllegalArgumentException("Role cannot be null or empty");
        }
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        if (join_date == null) {
            throw new IllegalArgumentException("Join date cannot be null");
        }
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
    }
}
