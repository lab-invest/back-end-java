package com.example.investlab.view.service;

import com.example.investlab.controller.request.StockRequest;
import com.example.investlab.model.entitys.User;

public interface BuyStockService {

    void addStockToWallet(User user, StockRequest stockRequest);
    void addStockToSpecificWallet(User user, StockRequest stockRequest, String walletName);
}
