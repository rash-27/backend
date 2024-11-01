package com.dbms.backend.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbms.backend.models.user.UserDetails;
import com.dbms.backend.service.user.UserService;

@RestController
@RequestMapping("/user")
public class UserController{

  @Autowired
  UserService userService;

    @PutMapping("{id}")
    public ResponseEntity<Boolean> updateEmployeeDetailsById(@PathVariable("id") int id, @RequestBody UserDetails userDetails) {
        try{
            userService.updateUserDetailsById(id, userDetails.password(), userDetails.name());
            return ResponseEntity.ok(true);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(false);
        }
    }

}
