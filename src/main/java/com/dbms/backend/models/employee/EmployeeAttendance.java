package com.dbms.backend.models.employee;

import java.time.LocalDate;

public record EmployeeAttendance(int id, int employee_id, LocalDate leave_date) {
    public EmployeeAttendance {
        if (leave_date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
    }
    
}
