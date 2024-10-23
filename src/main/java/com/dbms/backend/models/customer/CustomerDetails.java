package com.dbms.backend.models.customer;

public record CustomerDetails(int id, String name, String address, String phone_number, String email, int points) {
    public CustomerDetails {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        if (phone_number == null || phone_number.isBlank()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (points < 0) {
            throw new IllegalArgumentException("Points cannot be negative");
        }
    }
}
