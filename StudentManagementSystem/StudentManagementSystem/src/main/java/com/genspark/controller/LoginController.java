package com.genspark.controller;

import com.genspark.Dto.LoginDTO;
import com.genspark.response.LoginResponse;
import com.genspark.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/login")
public class LoginController {

    @Autowired
    private UserService userService;
    @PostMapping(path="/log")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
        LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}
