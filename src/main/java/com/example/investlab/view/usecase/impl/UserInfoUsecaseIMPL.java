package com.example.investlab.view.usecase.impl;

import com.example.investlab.model.entitys.User;
import com.example.investlab.view.service.VerifyUserService;
import com.example.investlab.view.usecase.UserInfoUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserInfoUsecaseIMPL implements UserInfoUsecase {

    private final VerifyUserService verifyUserService;
    @Override
    public Optional<User> getUserInfo(String email) {
        Optional<User> user = verifyUserService.getUser(email);
        return user;
    }

    @Override
    public double getUserBalance(String email) {
        Optional<User> user = verifyUserService.getUser(email);
        return user.get().getBalance();
    }
}
