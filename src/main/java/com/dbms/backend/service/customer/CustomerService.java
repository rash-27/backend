package com.dbms.backend.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.dbms.backend.models.customer.CustomerDetails;
import com.dbms.backend.repo.customer.CustomerRepo;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    public List<CustomerDetails> getCustomer() {
        try{
            return customerRepo.getCustomer();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addCustomer(CustomerDetails customerDetails) {
        try{
            customerRepo.addCustomer(customerDetails);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCustomerPoints(int id, CustomerDetails customerDetails) {
        try{
            customerRepo.updateCustomerPoints(id, customerDetails);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
