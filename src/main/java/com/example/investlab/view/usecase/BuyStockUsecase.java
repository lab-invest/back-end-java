package com.example.investlab.view.usecase;

import com.example.investlab.controller.request.StockRequest;

public interface BuyStockUsecase {
    void buyStock(String uuid, StockRequest stockRequest, String walletName);
}
