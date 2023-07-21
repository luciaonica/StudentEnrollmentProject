package com.genspark.service;

import com.genspark.Dto.LoginDTO;
import com.genspark.Dto.UserDTO;
import com.genspark.entity.User;
import com.genspark.response.LoginResponse;

import java.util.List;

public interface UserService {

    String addUser(UserDTO userDTO);

    LoginResponse loginUser(LoginDTO loginDTO);

    List<User> getAllStudents();

    User getUserById(int studentId);

    String deleteStudent(int studentId);

    User updateUser(UserDTO userDTO);

    List<User> getAllTeachers();

    User updateAccount(UserDTO userDTO);
}
