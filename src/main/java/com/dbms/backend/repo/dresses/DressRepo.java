package com.dbms.backend.repo.dresses;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dbms.backend.models.dresses.DressDetailsRowMapper;
import com.dbms.backend.models.dresses.DressDetails;
import java.util.List;

@Repository
public class DressRepo {
    
    private JdbcTemplate jdbcTemplate;
    
    public DressRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    // No deletion is allowed
    public void addDress(DressDetails dressDetails) {
        try{
            String sql = "INSERT INTO dress (name, brand, gender, size, color, required_quantity) VALUES (?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, dressDetails.name(), dressDetails.brand(), dressDetails.gender(), dressDetails.size(), dressDetails.color(), dressDetails.required_quantity());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateDress(int id, DressDetails dressDetails){
        if(id != dressDetails.id()){
            throw new IllegalArgumentException("Id in path and body do not match");
        }
        try{
            String sql = "Update dress SET name SET name = ?, brand = ?, gender = ?, size = ?, color = ?, required_quantity = ? WHERE id = ?";
            jdbcTemplate.update(sql, dressDetails.name(), dressDetails.brand(), dressDetails.gender(), dressDetails.size(), dressDetails.color(), dressDetails.required_quantity(), id);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<DressDetails> getDress() {
        try{
            String sql = "SELECT * FROM dress";
            return jdbcTemplate.query(sql,new DressDetailsRowMapper());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
