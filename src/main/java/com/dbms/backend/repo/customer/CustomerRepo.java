package com.dbms.backend.repo.customer;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.dbms.backend.models.customer.CustomerDetails;
import com.dbms.backend.models.customer.CustomerDetailsRowMapper;
@Repository
public class CustomerRepo {

    JdbcTemplate jdbcTemplate;

    public CustomerRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CustomerDetails> getCustomer() {
        try{
            String sql = "SELECT * FROM customer";
            return jdbcTemplate.query(sql,new CustomerDetailsRowMapper());

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addCustomer(CustomerDetails customerDetails) {
        try{
            String sql = "INSERT INTO customer (name, address, email, phone_number, points) VALUES (?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, customerDetails.name(), customerDetails.address(), customerDetails.email(), customerDetails.phone_number(), customerDetails.points());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCustomerPoints(int id, CustomerDetails customerDetails) {
        try{
            String sql = "UPDATE customer SET name = ?, address = ?, email = ?, phone_number = ?, points = ? WHERE id = ?";
            jdbcTemplate.update(sql,customerDetails.name(), customerDetails.address(), customerDetails.email(), customerDetails.phone_number(), customerDetails.points() , id);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
