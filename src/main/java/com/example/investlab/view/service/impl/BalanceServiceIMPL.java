package com.example.investlab.view.service.impl;

import com.example.investlab.model.repository.UserRepository;
import com.example.investlab.view.exception.InsufficientBalanceException;
import com.example.investlab.view.exception.UserNotFoundException;
import com.example.investlab.view.service.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BalanceServiceIMPL implements BalanceService {

    private final UserRepository userRepository;


    @Override
    public boolean validateBalance(String email, double amount) {
        var user = userRepository.findByEmail(email);
        return user.get().getBalance() > amount;
    }

    @Override
    public void updateBalance(String email, double amount, double totalPrice) {
        if (validateBalance(email, totalPrice)) {
            userRepository.updateBalance(email, amount);
            return;
        }
        throw new InsufficientBalanceException("Insufficient balance");
    }

}
