package com.uol.api.controller;

import com.uol.api.model.dto.UserDto;
import com.uol.api.repository.UserRepository;
import com.uol.api.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity saveUser(@RequestBody @Valid UserDto userDto){
        userService.saveUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
