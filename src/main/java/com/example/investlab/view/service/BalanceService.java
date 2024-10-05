package com.example.investlab.view.service;

import com.example.investlab.controller.request.StockRequest;
import com.example.investlab.model.entitys.User;

public interface BalanceService {
    boolean validateBalance(String uuid, double amount);
    void updateBalance(String uuid, double amount, double totalPrice);
}
