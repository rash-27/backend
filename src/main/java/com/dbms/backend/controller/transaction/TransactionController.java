package com.dbms.backend.controller.transaction;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("/transaction")
public class TransactionController {
    
}
