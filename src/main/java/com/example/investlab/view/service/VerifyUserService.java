package com.example.investlab.view.service;

import com.example.investlab.model.entitys.User;

import java.util.Optional;

public interface VerifyUserService {

    boolean userExists(String email);
    boolean userNotExists(String email);
    Optional<User> getUser(String email);
}
