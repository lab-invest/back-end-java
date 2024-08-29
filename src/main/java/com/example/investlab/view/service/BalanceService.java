package com.example.investlab.view.service;

import com.example.investlab.controller.request.StockRequest;
import com.example.investlab.model.entitys.User;

public interface BalanceService {
    boolean validateBalance(String email, double amount);
    void updateBalance(String email, double amount, double totalPrice);
}
