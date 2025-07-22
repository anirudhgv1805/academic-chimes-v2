package com.academicchimes.app.models;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String username;
    private String password;
    private String email;
    private Role role;
    private String dept;
    private String section;
    private int batch;

    private boolean isOnline;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    private LocalDateTime lastSeen;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @CreationTimestamp
    private LocalDateTime createdAt;


    @ManyToMany
    @JoinTable(
        name = "user_groups",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<Group> groups;

    @ManyToMany
    @JoinTable(
        name = "user_contacts", 
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "contact_id")
    )
    private Set<User> contacts;
    
    public User() {
    }

    public User(String userId, String username, String password, String email, Role role, String dept, String section, int batch) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.dept = dept;
        this.section = section;
        this.batch = batch;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
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


    public User(Long id, String userId, String username, String password, String email, Role role, String dept, String section, int batch, boolean isOnline, UserStatus userStatus, LocalDateTime lastSeen, LocalDateTime updatedAt, LocalDateTime createdAt, Set<Group> groups, Set<User> contacts) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.dept = dept;
        this.section = section;
        this.batch = batch;
        this.isOnline = isOnline;
        this.userStatus = userStatus;
        this.lastSeen = lastSeen;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.groups = groups;
        this.contacts = contacts;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isIsOnline() {
        return this.isOnline;
    }

    public boolean getIsOnline() {
        return this.isOnline;
    }

    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    public UserStatus getUserStatus() {
        return this.userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public LocalDateTime getLastSeen() {
        return this.lastSeen;
    }

    public void setLastSeen(LocalDateTime lastSeen) {
        this.lastSeen = lastSeen;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Group> getGroups() {
        return this.groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Set<User> getContacts() {
        return this.contacts;
    }

    public void setContacts(Set<User> contacts) {
        this.contacts = contacts;
    }

    public User id(Long id) {
        setId(id);
        return this;
    }

    public User userId(String userId) {
        setUserId(userId);
        return this;
    }

    public User username(String username) {
        setUsername(username);
        return this;
    }

    public User password(String password) {
        setPassword(password);
        return this;
    }

    public User email(String email) {
        setEmail(email);
        return this;
    }

    public User role(Role role) {
        setRole(role);
        return this;
    }

    public User dept(String dept) {
        setDept(dept);
        return this;
    }

    public User section(String section) {
        setSection(section);
        return this;
    }

    public User batch(int batch) {
        setBatch(batch);
        return this;
    }

    public User isOnline(boolean isOnline) {
        setIsOnline(isOnline);
        return this;
    }

    public User userStatus(UserStatus userStatus) {
        setUserStatus(userStatus);
        return this;
    }

    public User lastSeen(LocalDateTime lastSeen) {
        setLastSeen(lastSeen);
        return this;
    }

    public User updatedAt(LocalDateTime updatedAt) {
        setUpdatedAt(updatedAt);
        return this;
    }

    public User createdAt(LocalDateTime createdAt) {
        setCreatedAt(createdAt);
        return this;
    }

    public User groups(Set<Group> groups) {
        setGroups(groups);
        return this;
    }

    public User contacts(Set<User> contacts) {
        setContacts(contacts);
        return this;
    }

    
    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", email='" + getEmail() + "'" +
            ", role='" + getRole() + "'" +
            ", dept='" + getDept() + "'" +
            ", section='" + getSection() + "'" +
            ", batch='" + getBatch() + "'" +
            "}";
    }

}
