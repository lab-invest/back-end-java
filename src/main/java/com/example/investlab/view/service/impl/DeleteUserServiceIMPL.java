package com.example.investlab.view.service.impl;

import com.example.investlab.model.repository.UserRepository;
import com.example.investlab.view.exception.UserDeletionException;
import com.example.investlab.view.service.DeleteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteUserServiceIMPL implements DeleteUserService {

    private final UserRepository userRepository;

    @Override
    public void deleteUser(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            userRepository.deleteByEmail(email);
        }
        throw new UserDeletionException("Fail to delete user with email: " + email);
    }
}

