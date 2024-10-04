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
    public boolean validateBalance(String uuid, double amount) {
        var user = userRepository.findByUuid(uuid);
        return user.get().getBalance() > amount;
    }

    @Override
    public void updateBalance(String uuid, double amount, double totalPrice) {
        if (validateBalance(uuid, totalPrice)) {
            userRepository.updateBalance(uuid, amount);
            return;
        }
        throw new InsufficientBalanceException("Insufficient balance");
    }

}
