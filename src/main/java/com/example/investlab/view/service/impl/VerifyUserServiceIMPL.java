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
    public boolean userExists(String uuid) {
        if(userRepository.findByUuid(uuid).isEmpty()){
            return false;
        }
        throw new UserCreationException("User already exists");
    }
    @Override
    public boolean userNotExists(String uuid) {
        if(userRepository.findByUuid(uuid).isPresent()){
            return true;
        }
        throw new UserNotFoundException("User not found exists");
    }

    @Override
    public Optional<User> getUser(String uuid) {
        Optional<User> user = userRepository.findByUuid(uuid);
        if(user.isEmpty()){
            throw new UserNotFoundException("User Not Found");
        }
        return user;
    }
}
