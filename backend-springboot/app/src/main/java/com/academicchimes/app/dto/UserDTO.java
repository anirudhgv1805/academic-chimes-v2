package com.academicchimes.app.dto;

import com.academicchimes.app.models.User;

public class UserDTO {
    private String username;
    private String userId;
    private String email;
    private String role;
    private String dept;
    private String section;
    private int batch;

    public UserDTO(){

    }

    public UserDTO(User user){
        this.username = user.getUsername();
        this.userId = user.getUserId();
        this.email = user.getEmail();
        this.role = user.getRole();
        this.dept = user.getDept();
        this.section = user.getSection();
        this.batch = user.getBatch();
    }

    public UserDTO(String username, String userId, String email, String role, String dept, String section, int batch) {
        this.username = username;
        this.userId = userId;
        this.email = email;
        this.role = role;
        this.dept = dept;
        this.section = section;
        this.batch = batch;
    }


    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDept() {
        return this.dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getSection() {
        return this.section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getBatch() {
        return this.batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", userId='" + getUserId() + "'" +
            ", email='" + getEmail() + "'" +
            ", role='" + getRole() + "'" +
            ", dept='" + getDept() + "'" +
            ", section='" + getSection() + "'" +
            ", batch='" + getBatch() + "'" +
            "}";
    }

}
