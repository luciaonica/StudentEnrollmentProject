package com.genspark.service;

import com.genspark.Dto.CourseDTO;
import com.genspark.Dto.LoginDTO;
import com.genspark.Dto.UserDTO;
import com.genspark.entity.Course;
import com.genspark.entity.User;
import com.genspark.repository.UserRepo;
import com.genspark.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDTO userDTO) {

        User user = new User(
                userDTO.getUserId(),
                userDTO.getUserFirstName(),
                userDTO.getUserLastName(),
                userDTO.getEmail(),
                this.passwordEncoder.encode(userDTO.getPassword()),
                userDTO.getRole()
        );

        userRepo.save(user);

        return user.getUserFirstName();
    }

    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        User user1 = userRepo.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginResponse("Login Success", true, user.get().getRole(), user.get().getUserId(), user.get().getUserFirstName()+ " " + user.get().getUserLastName());
                } else {
                    return new LoginResponse("Login Failed", false, "", 0, "");
                }
            } else {
                return new LoginResponse("password Not Match", false, "", 0, "");
            }
        } else {
            return new LoginResponse("Email does not exist", false, "", 0, "");
        }
    }

    @Override
    public List<User> getAllStudents() {
        return userRepo.findAllStudents();
    }

    @Override
    public User getUserById(int studentId) {
        Optional<User> u = userRepo.findById(studentId);
        User user = null;
        if (u.isPresent()){
            user = u.get();
        } else {
            throw new RuntimeException("User ID " + studentId + " not found");
        }
        return user;
    }


    @Override
    public User updateUser(UserDTO userDTO) {
        User student = getUserById(userDTO.getUserId());
        student.setUserFirstName(userDTO.getUserFirstName());
        student.setUserLastName(userDTO.getUserLastName());
        student.setEmail(userDTO.getEmail());
        return userRepo.save(student);

    }

    @Override
    public List<User> getAllTeachers() {
        return userRepo.findAllTeachers();
    }

    @Override
    public User updateAccount(UserDTO userDTO) {
        User account = getUserById(userDTO.getUserId());
        account.setUserFirstName(userDTO.getUserFirstName());
        account.setUserLastName(userDTO.getUserLastName());
        account.setEmail(userDTO.getEmail());
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
        account.setPassword(encodedPassword);
        return userRepo.save(account);
    }

    @Override
    public String deleteStudent(int studentId) {
        userRepo.deleteById(studentId);
        return "Student deleted";
    }

}
