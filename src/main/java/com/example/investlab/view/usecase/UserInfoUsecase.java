package com.example.investlab.view.usecase;

import com.example.investlab.model.entitys.User;

import java.util.Optional;

public interface UserInfoUsecase {
    Optional<User> getUserInfo(String email);
    double getUserBalance(String email);
}
