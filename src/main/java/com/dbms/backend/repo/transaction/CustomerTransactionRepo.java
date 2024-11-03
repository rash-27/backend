package com.dbms.backend.repo.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dbms.backend.models.stock.StockDescription;
import com.dbms.backend.models.transaction.CustomerCompleteTransaction;
import com.dbms.backend.models.transaction.CustomerTransaction;

@Repository
public class CustomerTransactionRepo {

    private JdbcTemplate jdbcTemplate;

    CustomerTransactionRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void addCustomerTransaction(CustomerTransaction customerTransaction) {
        try{
            // Adding in Customer Transaction
            String custSql = "INSERT INTO customer_transaction (customer_id, transaction_date, amount) VALUES (?, ?, ?)";
            jdbcTemplate.update(custSql, customerTransaction.customer_id(), customerTransaction.transaction_date(), customerTransaction.amount());
            int id = jdbcTemplate.queryForObject("SELECT MAX(id) FROM customer_transaction", Integer.class);
            // Updating and adding stock to customer and inventory to customer_inventory
            for(StockDescription stockDescription : customerTransaction.StockDescription()) {

                // Inventory in customer transaction
                String stockSql = "INSERT INTO inventory_in_cust_transaction (inventory_id, customer_transaction_id, quantity) VALUES (?, ?, ?)";
                jdbcTemplate.update(stockSql, stockDescription.id(), id, stockDescription.available_quantity()+ stockDescription.damaged_quantity());

                //Inventory bought by customer
                String inventory_bought_by_customer = "INSERT INTO inventory_bought_by_customer (customer_id, inventory_id) VALUES (?, ?)";
                jdbcTemplate.update(inventory_bought_by_customer, customerTransaction.customer_id(), stockDescription.id());

                // Update stock
                String updateStock = "UPDATE stock SET available_quantity = available_quantity - ?, damaged_quantity = damaged_quantity - ?  WHERE id = ?";
                jdbcTemplate.update(updateStock, stockDescription.available_quantity(), stockDescription.damaged_quantity(), stockDescription.id());
            }

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }

    public List<CustomerCompleteTransaction> getCustomerTransaction(int user_id){
      string sql = "SELECT DISTINCT()  FROM users AS u, customers AS c, customer_transaction AS ct, 
                    inventory_in_cust_transaction AS ict, inventory as i, dress AS d WHERE 
                    u.id = c.user_id AND c.id = ct.customer_id AND ct.id = ict.customer_transaction_id
                    AND ict.inventory_id = i.id AND i.dress_id = d.id"; 
  }
}
