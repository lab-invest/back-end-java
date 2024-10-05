package com.example.investlab.view.service;

import com.example.investlab.model.entitys.User;

import java.util.Optional;

public interface VerifyUserService {

    boolean userExists(String uuid);
    boolean userNotExists(String uuid);
    Optional<User> getUser(String uuid);
}
