package com.dbms.backend.models.employee;

import java.util.List;


public record EmployeeCompleteDetails(EmployeeDetails employeeDetails, List<EmployeePhone> phones, List<EmployeeEmail> emails, List<EmployeeAttendance> attendances) {

    public EmployeeCompleteDetails(EmployeeDetails employeeDetails, List<EmployeePhone> phones, List<EmployeeEmail> emails, List<EmployeeAttendance> attendances) {
        this.employeeDetails = employeeDetails;
        this.phones = phones;
        this.emails = emails;
        this.attendances = attendances;
    }
}
