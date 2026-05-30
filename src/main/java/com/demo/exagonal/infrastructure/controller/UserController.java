package com.demo.exagonal.infrastructure.controller;

import com.demo.exagonal.application.port.input.CreateUserPort;
import com.demo.exagonal.application.port.input.GetUserPort;
import com.demo.exagonal.domain.model.User;
import com.demo.exagonal.domain.model.UserResponse;
import com.demo.exagonal.infrastructure.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final CreateUserPort createUserPort;
    private final GetUserPort getUserPort;


    public UserController(CreateUserPort createUserPort, GetUserPort getUserPort) {
        this.createUserPort = createUserPort;
        this.getUserPort = getUserPort;
    }


    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest){
        final User user = new User(null, userRequest.firstname(), userRequest.lastname());
        final User createdUser = createUserPort.createUser(user);
        return new UserResponse(createdUser.id(), createdUser.firstname(), createdUser.firstname());
    }

    @GetMapping("/{userId}")
    public UserResponse getUser(@PathVariable Long userId){
        final User user = getUserPort.findUserById(userId).orElseThrow(()->new IllegalArgumentException("User not found"));
        return new UserResponse(user.id(), user.firstname(), user.firstname());
    }


}
