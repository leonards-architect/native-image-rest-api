package com.example.demo.presentation;

import com.example.demo.application.UserQueryService;
import com.example.demo.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    UserQueryService userQueryService;

    public UserController(UserQueryService userQueryService) {
        this.userQueryService = userQueryService;
    }

    @GetMapping("/users")
    public List<User> users() {
        return userQueryService.getAll();
    }
}
