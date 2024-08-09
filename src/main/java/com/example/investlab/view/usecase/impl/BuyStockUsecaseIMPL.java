package com.example.investlab.view.usecase.impl;

import com.example.investlab.controller.request.StockRequest;
import com.example.investlab.view.service.BuyStockService;
import com.example.investlab.view.service.VerifyUserService;
import com.example.investlab.view.usecase.BuyStockUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.investlab.model.entitys.User;

@RequiredArgsConstructor
@Service
public class BuyStockUsecaseIMPL implements BuyStockUsecase {

    private final VerifyUserService verifyUserService;
    private final BuyStockService buyStockService;

    @Override
    public void buyStock(String email, StockRequest stockRequest, String walletName) {
        User user = verifyUserService.getUser(email).orElseThrow();
        if (walletName != null && !walletName.isEmpty()) {
            buyStockService.addStockToSpecificWallet(user, stockRequest, walletName);
            return;
        }
        buyStockService.addStockToWallet(user, stockRequest);
    }
}

