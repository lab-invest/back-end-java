package com.example.investlab.view.service.impl;

import com.example.investlab.model.entitys.User;
import com.example.investlab.model.entitys.Wallet;
import com.example.investlab.model.repository.UserRepository;
import com.example.investlab.view.service.InsertUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class InsertUserServiceIMPL implements InsertUserService {

    private final UserRepository userRepository;
    @Override
    public void insertUser(User user) {
        user.setWallets(Collections.singletonList(new Wallet("geral", Collections.emptyList())));
        userRepository.save(user);
    }
}
