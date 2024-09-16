package com.dbms.backend.controller.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dbms.backend.service.supplier.SupplierService;
import java.util.List;
import com.dbms.backend.models.supplier.SupplierDetails;
import com.dbms.backend.models.supplier.SupplierEmail;
import com.dbms.backend.models.supplier.SupplierPhone;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    SupplierService supplierService;


    @GetMapping
    public ResponseEntity<List<SupplierDetails>> getSupplier() {
        try{
            return ResponseEntity.ok(supplierService.getSupplier());
        }catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Boolean> addSupplier(@RequestBody SupplierDetails supplierDetails) {
        try{
            supplierService.addSupplier(supplierDetails);
            return ResponseEntity.ok(true);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(false);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteSupplierById(@RequestBody int id) {
        try{
            supplierService.deleteSupplierById(id);
            return ResponseEntity.ok(true);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(false);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Boolean> updateSupplierById(@RequestBody int id, SupplierDetails supplierDetails) {
        try{
            supplierService.updateSupplierById(id, supplierDetails);
            return ResponseEntity.ok(true);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(false);
        }
    }

    // Email Routes

    @PostMapping("{id}/email")
    public ResponseEntity<Boolean> addSupplierEmailById(@RequestBody int id, SupplierEmail supplierEmail) {
        try{
            supplierService.addSupplierEmailById(id, supplierEmail);
            return ResponseEntity.ok(true);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(false);
        }
    }

    @GetMapping("{id}/email")
    public ResponseEntity<List<SupplierEmail>> getSupplierEmailById(@RequestBody int id) {
        try{
            return ResponseEntity.ok(supplierService.getSupplierEmailById(id));
        }catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping("{id}/email/{email_id}")
    public ResponseEntity<Boolean> deleteSupplierEmailById(@RequestBody int id, int email_id) {
        try{
            supplierService.deleteSupplierEmailById(id, email_id);
            return ResponseEntity.ok(true);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(false);
        }
    }

    // Phone Routes

    @PostMapping("{id}/phone")
    public ResponseEntity<Boolean> addSupplierPhoneById(@RequestBody int id, SupplierPhone supplierPhone) {
        try{
            supplierService.addSupplierPhoneById(id, supplierPhone);
            return ResponseEntity.ok(true);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(false);
        }
    }

    @GetMapping("{id}/phone")
    public ResponseEntity<List<SupplierPhone>> getSupplierPhoneById(@RequestBody int id) {
        try{
            return ResponseEntity.ok(supplierService.getSupplierPhoneById(id));
        }catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping("{id}/phone/{phone_id}")
    public ResponseEntity<Boolean> deleteSupplierPhoneById(@RequestBody int id, int phone_id) {
        try{
            supplierService.deleteSupplierPhoneById(id, phone_id);
            return ResponseEntity.ok(true);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(false);
        }
    }

}
