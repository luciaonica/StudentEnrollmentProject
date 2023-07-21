package com.genspark.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name="user_id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name="first_name", length = 255)
    private String userFirstName;

    @Column(name="last_name", length = 255)
    private String userLastName;

    @Column(name="email", length = 255)
    private String email;

    @Column(name="password", length = 255)
    private String password;

    @Column(name="role", length = 255)
    private String role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<UserCourse> studentCourses = new ArrayList<>();

    public User(int userId, String userFirstName, String userLastName, String email, String password, String role) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
