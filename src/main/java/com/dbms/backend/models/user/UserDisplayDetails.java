package com.dbms.backend.models.user;

public record UserDisplayDetails(int id, String phone_number, String name, String role){
  public UserDisplayDetails{
         if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (phone_number == null || phone_number.isBlank()) {
            throw new IllegalArgumentException("Phone Number cannot be null or empty");
        }
        if (role == null || role.isBlank()) {
            throw new IllegalArgumentException("Role cannot be null or empty");
        }
  }
}
