package com.dbms.backend.models.employee;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeDetailsRowMapper implements RowMapper<EmployeeDetails> {
    @Override
    public EmployeeDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new EmployeeDetails(rs.getInt("id"), rs.getString("name"), rs.getString("role"), rs.getString("address"), rs.getDate("join_date").toLocalDate(), rs.getDouble("salary"));
    }       
}
