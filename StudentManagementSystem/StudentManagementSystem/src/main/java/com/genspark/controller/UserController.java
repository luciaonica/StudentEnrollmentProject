package com.genspark.controller;

import com.genspark.Dto.LoginDTO;
import com.genspark.Dto.UserDTO;
import com.genspark.response.LoginResponse;
import com.genspark.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path="/save")
    public String saveUser(@RequestBody UserDTO userDTO) {
        String id = userService.addUser(userDTO);

        return id;
    }


}
