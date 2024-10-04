package com.example.investlab.view.usecase.impl;

import com.example.investlab.model.entitys.Stock;
import com.example.investlab.model.entitys.User;
import com.example.investlab.view.service.VerifyUserService;
import com.example.investlab.view.usecase.UserInfoUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserInfoUsecaseIMPL implements UserInfoUsecase {

    private final VerifyUserService verifyUserService;
    @Override
    public Optional<User> getUserInfo(String uuid) {
        Optional<User> user = verifyUserService.getUser(uuid);
        return user;
    }

    @Override
    public double getUserBalance(String uuid) {
        Optional<User> user = verifyUserService.getUser(uuid);
        return user.get().getBalance();
    }

    @Override
    public Map<String, Map<String, Stock>> getUserWallets(String uuid) {
        Optional<User> user = verifyUserService.getUser(uuid);
        return user.get().getWallets();
    }
}
