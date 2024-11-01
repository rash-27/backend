package com.dbms.backend.repo.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dbms.backend.models.user.Role;
import com.dbms.backend.models.user.User;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(rs.getInt("id"), rs.getString("phone_number"), rs.getString("password"), Role.valueOf(rs.getString("role")), rs.getString("name"));
    }       
}
