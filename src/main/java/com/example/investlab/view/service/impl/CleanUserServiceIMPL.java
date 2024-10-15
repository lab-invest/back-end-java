package com.example.investlab.view.service.impl;

import com.example.investlab.model.repository.UserRepository;
import com.example.investlab.view.exception.UserDeletionException;
import com.example.investlab.view.service.CleanUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CleanUserServiceIMPL implements CleanUserService {

    private final UserRepository userRepository;

    @Override
    public void cleanUser(String uuid) {
        if (userRepository.findByUuid(uuid).isPresent()) {
            userRepository.resetBalance(uuid);
            userRepository.resetWallet(uuid);
            return;
        }

        throw new UserDeletionException("Fail to clean user with uuid: " + uuid);
    }

}
