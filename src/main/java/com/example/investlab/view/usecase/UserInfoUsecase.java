package com.example.investlab.view.usecase;

import com.example.investlab.model.entitys.Stock;
import com.example.investlab.model.entitys.User;

import java.util.Map;
import java.util.Optional;

public interface UserInfoUsecase {
    Optional<User> getUserInfo(String email);
    double getUserBalance(String email);
    Map<String, Map<String, Stock>> getUserWallets(String email);
}
