package com.dbms.backend.repo.user;

import org.springframework.stereotype.Repository;

import com.dbms.backend.models.user.User;
import com.dbms.backend.models.user.UserDetails;
import com.dbms.backend.models.user.UserDisplayDetails;

import java.util.List;
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
        String sql = "INSERT INTO users (name, phone_number, password, role) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, curr_user.getName(), curr_user.getPhone_number(), curr_user.getPassword(), curr_user.getRole().name());
        return true;
 
    } catch (Exception e) {
      System.out.println(e);
      throw new RuntimeException(e); 
    }
  }

  public Boolean addUserByAdmin(UserDetails user){
     try {
        String sql = "INSERT INTO users (name, phone_number, password) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.name(), user.phone_number(), user.password());
        return true;
 
    } catch (Exception e) {
      System.out.println(e);
      throw new RuntimeException(e); 
    }
 
  }


    public void updateUserDetailsById(int id, String password, String name) {
        try{
            String sql = "UPDATE users SET name = ?, password = ? WHERE id = ?";
            jdbcTemplate.update(sql, name, password, id);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUserByAdmin(int id) {
        try{
            String sql = "DELETE FROM users WHERE id = ?";
            jdbcTemplate.update(sql, id);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<UserDisplayDetails> getUsersDisplay() {
        try{
            String sql = "SELECT * FROM users";
            return jdbcTemplate.query(sql, (rs, rowNum) -> new UserDisplayDetails(rs.getInt("id"), rs.getString("phone_number"), rs.getString("role"), rs.getString("name")));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
