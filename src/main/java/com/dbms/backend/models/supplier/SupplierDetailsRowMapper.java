package com.dbms.backend.models.supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class SupplierDetailsRowMapper implements RowMapper<SupplierDetails> {

    @Override
    public SupplierDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new SupplierDetails(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("address")
    );
    }
    
}
