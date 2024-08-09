package com.example.investlab.view.usecase;

import com.example.investlab.controller.request.StockRequest;

public interface BuyStockUsecase {
    void buyStock(String email, StockRequest stockRequest, String walletName);
}
