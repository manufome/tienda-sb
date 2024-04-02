package com.laFortaleza.tienda.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String username;
    private String password;
    private String email;
    private String name;
    private String confirmPassword;
    private String address;
    private String role;

    public UserDTO(String username, String password, String name, String email, String address) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public UserDTO() {
    }

    public String toString() {
        return "UserDTO(username=" + this.getUsername() + ", password=" + this.getPassword() + ", email=" + this.getEmail() + ", name=" + this.getName() + ", confirmPassword=" + this.getConfirmPassword() + ", address=" + this.getAddress() + ", role=" + this.getRole() + ")";
    }




}
