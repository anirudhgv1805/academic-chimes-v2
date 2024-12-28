package com.academicchimes.app.dto;

public class LoginRequest {

    private String userId;
    private String password;


    public String getUserId(){
        return userId;
    }

    public String getPassword(){
        return password;
    }
    
    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }
    
}
