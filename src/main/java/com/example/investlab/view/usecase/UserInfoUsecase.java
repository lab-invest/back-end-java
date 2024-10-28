package com.example.investlab.view.usecase;

import com.example.investlab.model.entitys.Stock;
import com.example.investlab.model.entitys.User;
import com.example.investlab.model.entitys.UserResponse;

import java.util.Map;
import java.util.Optional;

public interface UserInfoUsecase {
    UserResponse getUserInfo(String uuid);
    double getUserBalance(String uuid);
    Map<String, Map<String, Stock>> getUserWallets(String uuid);

    Map<String, Stock> getUserWallet(String uuid, String wallet);

    Map<String, Map<String, Stock>> getUserWalletsComparison(String uuid);
    void updateUserRentability(String uuid);
}
