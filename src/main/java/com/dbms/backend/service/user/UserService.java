package com.dbms.backend.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbms.backend.models.user.UserDetails;
import com.dbms.backend.repo.user.UserRepo;

@Service
public class UserService{
    
    @Autowired
    UserRepo userRepo;

    public void addUserByAdmin(UserDetails userDetails) {
        try{
            userRepo.addUserByAdmin(userDetails);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

     public void updateUserDetailsById(int id, String password, String name) {
        try{
            userRepo.updateUserDetailsById(id, password, name);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void deleteUserByAdmin(int id) {
        try{
            userRepo.deleteUserByAdmin(id);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
