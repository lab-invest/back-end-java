package com.example.investlab.model.dto;

import com.example.investlab.controller.request.UserRequest;
import com.example.investlab.model.entitys.User;
import com.example.investlab.model.entitys.Wallet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserDTO {
    public User toUser(UserRequest userRequest) {
        return User.builder()
                .cpf(userRequest.getCpf())
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .experience(userRequest.getExperience())
                .birth_date(userRequest.getBirthDate())
                .balance(10000.0)
                .wallets(new ArrayList<Wallet>())
                .userPhoto(userRequest.getUserPhoto())
                .build();
    }
}
