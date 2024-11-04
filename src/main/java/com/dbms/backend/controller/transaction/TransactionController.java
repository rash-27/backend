package com.dbms.backend.controller.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbms.backend.models.transaction.CustomerCompleteTransaction;
import com.dbms.backend.models.transaction.CustomerTransaction;
import com.dbms.backend.models.transaction.UpdateTransactionInfo;
import com.dbms.backend.service.transaction.TransactionService;
import com.dbms.backend.utils.GetTokenInfo;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    GetTokenInfo getTokenInfo;

    @Autowired 
    TransactionService transactionService;
   // Customer 
   
    // Get all customer transactions
    @GetMapping("/customer/{cust_id}")
     public ResponseEntity<List<CustomerCompleteTransaction>> getCompleteCustomerTransactions(@PathVariable("id") int cust_id){
    try {
     return ResponseEntity.ok(transactionService.getCompleteCustomerTransactions(cust_id));

    } catch (Exception e) {
      return ResponseEntity.status(500).body(null);

    }
  }   

    // Add a customer tranasaction
    @PostMapping("/customer/{cust_id}")
    public ResponseEntity<Boolean> addCustomerTransaction(@PathVariable("cust_id") int cust_id, @RequestBody CustomerTransaction customerTransaction, HttpServletRequest request) {
        try{
            int user_id = Integer.parseInt(getTokenInfo.getId(request));
            transactionService.addCustomerTransaction(customerTransaction, user_id);
            return ResponseEntity.ok(true);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(false);
        }
    }   

    // Delete a customer transaction
    @DeleteMapping("/customer/{cust_id}")
    public ResponseEntity<Boolean> addCustomerTransaction(@PathVariable("cust_id") int cust_id, HttpServletRequest request) {
        try{
            int user_id = Integer.parseInt(getTokenInfo.getId(request));
            transactionService.deleteAllCustomerTransaction(cust_id, user_id);
            return ResponseEntity.ok(true);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(false);
        }
    }
    
    // Delete all customer transactions 
     @DeleteMapping("{trxn_id}/customer/{cust_id}")
    public ResponseEntity<Boolean> addCustomerTransaction(@PathVariable("cust_id") int cust_id, @PathVariable("trxn_id") int trxn_id, HttpServletRequest request) {
        try{
            int user_id = Integer.parseInt(getTokenInfo.getId(request));
            transactionService.deleteCustomerTransactionById(cust_id, trxn_id, user_id);
            return ResponseEntity.ok(true);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(false);
        }
    } 
   

    // Update a customer transaction
    @PutMapping("{trxn_id}/customer/{cust_id}")
    public ResponseEntity<Boolean> updateCustomerTransactionById(@PathVariable("cust_id") int cust_id, @PathVariable("trxn_id") int trxn_id, @RequestBody UpdateTransactionInfo transactionInfo, HttpServletRequest request) {
        try{
            int user_id = Integer.parseInt(getTokenInfo.getId(request));
            transactionService.updateCustomerTransactionById(cust_id, trxn_id, transactionInfo);
            return ResponseEntity.ok(true);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(false);
        }
    }
    // Get all the user transactions of the a user 
    @GetMapping("/customer")
     public ResponseEntity<List<CustomerCompleteTransaction>> getTransactionsOfAllCustomers(HttpServletRequest request){
    try { 
      int user_id = Integer.parseInt(getTokenInfo.getId(request));
      return ResponseEntity.ok(transactionService.getTransactionsOfAllCustomers(user_id));
    } catch (Exception e) {
        return ResponseEntity.status(500).body(null);
    }
  }


  // Supplier
  
}
