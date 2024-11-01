package com.dbms.backend.repo.user;

import org.springframework.stereotype.Repository;

import com.dbms.backend.models.user.User;


import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import com.dbms.backend.repo.user.UserRowMapper;

@Repository
public class UserRepo{
     private JdbcTemplate jdbcTemplate;

    UserRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

   public User findByPhone(String phone_number){
    try{
      String sql = "SELECT * FROM users WHERE phone_number = ?";
      return jdbcTemplate.query(sql, new UserRowMapper(), phone_number).stream().findFirst().orElse(null);
    }catch(Exception e){
       throw new RuntimeException(e);
    }
  }

  public Boolean addUser(User curr_user){
    try {
        System.out.println("At repo layer whhile adding");
        System.out.println("Name "+ curr_user.getName());
        System.out.println("Pwd "+ curr_user.getPassword());
        String sql = "INSERT INTO users (name, phone_number, password, role) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, curr_user.getName(), curr_user.getPhone_number(), curr_user.getPassword(), curr_user.getRole().name());
        return true;
 
    } catch (Exception e) {
      System.out.println(e);
      throw new RuntimeException(e); 
    }
  }
}
