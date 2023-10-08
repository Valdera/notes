package com.bikin2ai.notes.handler.http;

import com.bikin2ai.notes.dto.request.UserCreationDTO;
import com.bikin2ai.notes.dto.response.UserDTO;
import com.bikin2ai.notes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/api/v1/user")
    public UserDTO getUserByID(@Validated @RequestBody UserCreationDTO body) {
        return userService.createUser(body);
    }

    @GetMapping("/api/v1/user/{id}")
    public UserDTO getUserByID(@PathVariable("id") UUID id){
        return userService.getUserByID(id).get();
    }

}
