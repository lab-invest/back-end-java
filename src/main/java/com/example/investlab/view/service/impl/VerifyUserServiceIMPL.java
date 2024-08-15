package com.example.investlab.view.service.impl;

import com.example.investlab.model.entitys.User;
import com.example.investlab.model.repository.UserRepository;
import com.example.investlab.view.exception.UserCreationException;
import com.example.investlab.view.exception.UserNotFoundException;
import com.example.investlab.view.service.VerifyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VerifyUserServiceIMPL implements VerifyUserService {

    private final UserRepository userRepository;

    @Override
    public boolean userExists(String email) {
        if(userRepository.findByEmail(email).isEmpty()){
            return false;
        }
        throw new UserCreationException("User already exists");
    }
    @Override
    public boolean userNotExists(String email) {
        if(userRepository.findByEmail(email).isPresent()){
            return true;
        }
        throw new UserNotFoundException("User not found exists");
    }

    @Override
    public Optional<User> getUser(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if(!user.isPresent()){
            throw new UserNotFoundException("User Not Found");
        }
        return user;
    }
}
