package com.dbms.backend.models.dresses;
// id here is dressId
public record DressDetails(int id, String name, String brand, String gender, String size, String color, int required_quantity) {
    public DressDetails {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (brand == null || brand.isBlank()) {
            throw new IllegalArgumentException("Brand cannot be null or empty");
        }
        if(gender == null || gender.isBlank()) {
            throw new IllegalArgumentException("Gender cannot be null or empty");
        }
        if(size == null || size.isBlank()) {
            throw new IllegalArgumentException("Size cannot be null or empty");
        }
        if(color == null || color.isBlank()) {
            throw new IllegalArgumentException("Color cannot be null or empty");
        }
        if(required_quantity < 0) {
            throw new IllegalArgumentException("Required quantity cannot be negative");
        }
    }
        
}
