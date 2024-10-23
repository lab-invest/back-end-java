package com.example.investlab.view.usecase.impl;

import com.example.investlab.controller.mapper.StockMapper;
import com.example.investlab.model.entitys.Stock;
import com.example.investlab.model.entitys.User;
import com.example.investlab.model.repository.UserRepository;
import com.example.investlab.view.client.BffClient;
import com.example.investlab.view.exception.UserNotFoundException;
import com.example.investlab.view.service.VerifyUserService;
import com.example.investlab.view.usecase.UserInfoUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserInfoUsecaseIMPL implements UserInfoUsecase {

    private final VerifyUserService verifyUserService;
    private final BffClient client;
    private final StockMapper mapper;
    private final UserRepository repository;
    @Override
    public Optional<User> getUserInfo(String uuid) {
        this.updateUserRentability(uuid);
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

    @Override
    public Map<String, Stock> getUserWallet(String uuid, String wallet) {
        if (wallet == null){
            wallet = "geral";
        }
        User user = verifyUserService.getUser(uuid).orElseThrow(() -> new UserNotFoundException("User not found"));
        return user.getWallets().get(wallet);
    }

    @Override
    public void updateUserRentability(String uuid) {
        var walletList = this.getUserWallet(uuid, "geral");
        var rentability = client.updateWalletRentability(mapper.convertToStockList(walletList));
        repository.updateRentability(uuid, rentability);
    }


}
