package com.dbms.backend.controller.dresses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dbms.backend.service.dresses.DressService;
import com.dbms.backend.models.dresses.DressDetails;
import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/dresses")
public class DressController {
    
    @Autowired
    DressService dressService;

    @GetMapping
    public ResponseEntity<List<DressDetails>> getDress() {
        try{
            return ResponseEntity.ok(dressService.getDress());
        }catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Boolean> addDress(@RequestBody DressDetails dressDetails) {
        try{
            dressService.addDress(dressDetails);
            return ResponseEntity.ok(true);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(false);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Boolean> updateDress(@PathVariable("id") int id, @RequestBody DressDetails dressDetails) {
        try{
            dressService.updateDress(id, dressDetails);
            return ResponseEntity.ok(true);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(false);
        }
    }
}
