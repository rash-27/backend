package com.dbms.backend.controller.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController{

  @GetMapping("/healthy")
  public String healthy (){
    return "Healthy admin";
  }
}
