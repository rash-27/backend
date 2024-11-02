package com.dbms.backend.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dbms.backend.models.customer.CustomerDetails;
import com.dbms.backend.service.customer.CustomerService;
import com.dbms.backend.utils.GetTokenInfo;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    GetTokenInfo getTokenInfo;

    // Customer Routes
    @GetMapping
    public ResponseEntity<List<CustomerDetails>> getCustomer(HttpServletRequest request) {
        try{
            int id = Integer.parseInt(getTokenInfo.getId(request));
            return ResponseEntity.ok(customerService.getCustomer());
        }catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
    
    @PostMapping
    public ResponseEntity<Boolean> addCustomer(@RequestBody CustomerDetails customerDetails, HttpServletRequest request) {
        try{
            int id = Integer.parseInt(getTokenInfo.getId(request));
            customerService.addCustomer(customerDetails);
            return ResponseEntity.ok(true);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(false);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Boolean> updateCustomerPoints(@RequestBody CustomerDetails customerDetails, HttpServletRequest request) {
        try{
            int id = Integer.parseInt(getTokenInfo.getId(request));
            customerService.updateCustomerPoints(customerDetails.id(), customerDetails);
            return ResponseEntity.ok(true);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(false);
        }
    }


}
