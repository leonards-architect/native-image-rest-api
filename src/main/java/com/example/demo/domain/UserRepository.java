package com.example.demo.domain;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
}
