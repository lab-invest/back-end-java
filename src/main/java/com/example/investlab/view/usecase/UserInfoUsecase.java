package com.example.investlab.view.usecase;

import com.example.investlab.model.entitys.Stock;
import com.example.investlab.model.entitys.User;

import java.util.Map;
import java.util.Optional;

public interface UserInfoUsecase {
    Optional<User> getUserInfo(String uuid);
    double getUserBalance(String uuid);
    Map<String, Map<String, Stock>> getUserWallets(String uuid);

    Map<String, Stock> getUserWallet(String uuid, String wallet);
    void updateUserRentability(String uuid);
}
