package com.example.investlab.view.usecase.impl;

import com.example.investlab.controller.request.StockRequest;
import com.example.investlab.utils.Utils;
import com.example.investlab.view.service.BalanceService;
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
    private final BalanceService balanceService;
    private final Utils utils;

    @Override
    public void buyStock(String email, StockRequest stockRequest, String walletName) {
        User user = verifyUserService.getUser(email).orElseThrow();
        var totalPrice = utils.calculateTotalPrice(stockRequest.getQuantity(), stockRequest.getAveragePrice());
        if (walletName != null && !walletName.isEmpty()) {
            buyStockService.addStockToSpecificWallet(user, stockRequest, walletName);
            return;
        } else{
            buyStockService.addStockToWallet(user, stockRequest);
        }
        balanceService.updateBalance(email, totalPrice);
    }
}

