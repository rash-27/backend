package com.dbms.backend.models.dresses;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class DressDetailsRowMapper implements RowMapper<DressDetails> {

    @Override
    public DressDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new DressDetails(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("brand"),
            rs.getString("gender"),
            rs.getString("size"),
            rs.getString("color"),
            rs.getInt("required_quantity")
    );
    
    }
}
