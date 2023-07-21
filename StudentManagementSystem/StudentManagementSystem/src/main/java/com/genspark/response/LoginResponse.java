package com.genspark.response;

public class LoginResponse {

    String message;
    Boolean status;
    String role;
    int id;
    String fullName;

    public LoginResponse() {
    }

    public LoginResponse(String message, Boolean status, String role, int id, String fullName) {
        this.message = message;
        this.status = status;
        this.role = role;
        this.id = id;
        this.fullName = fullName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", role='" + role + '\'' +
                '}';
    }
}
