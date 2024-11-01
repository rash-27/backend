package com.dbms.backend.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbms.backend.models.user.UserDetails;
import com.dbms.backend.service.user.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController{
  
    @Autowired
    UserService userService;

    @GetMapping("/healthy")
    public String healthy (){
      return "Healthy admin";
    }


    @PostMapping("/add_user")
    public ResponseEntity<Boolean> addUserByAdmin(@RequestBody UserDetails userDetails) {
        try{
            userService.addUserByAdmin(userDetails);
            return ResponseEntity.ok(true);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(false);
        }
    }

    @DeleteMapping("/delete_user/{id}")
    public ResponseEntity<Boolean> deleteUserByAdmin(@PathVariable("id") int id) {
        try{
            userService.deleteUserByAdmin(id);
            return ResponseEntity.ok(true);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(false);
        }
    }

}
