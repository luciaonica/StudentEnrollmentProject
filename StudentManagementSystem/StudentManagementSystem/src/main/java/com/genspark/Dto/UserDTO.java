package com.genspark.Dto;

public class UserDTO {

    private int userId;

    private String UserFirstName;

    private String UserLastName;

    private String email;

    private String password;

    private String role;

    public UserDTO() {
    }

    public UserDTO(int userId, String userFirstName, String userLastName, String email, String password, String role) {
        this.userId = userId;
        UserFirstName = userFirstName;
        UserLastName = userLastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return UserFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        UserFirstName = userFirstName;
    }

    public String getUserLastName() {
        return UserLastName;
    }

    public void setUserLastName(String userLastName) {
        UserLastName = userLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", UserFirstName='" + UserFirstName + '\'' +
                ", UserLastName='" + UserLastName + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
