package com.example.investlab.model.dto;

import com.example.investlab.controller.request.UserRequest;
import com.example.investlab.model.entitys.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;


@Component
public class UserDTO {
    public User toUser(UserRequest userRequest) {
        return User.builder()
                .uuid(userRequest.getUuid())
                .cpf(userRequest.getCpf())
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .birth_date(userRequest.getBirthDate())
                .balance(10000.0)
                .wallets(new HashMap<>())
                .userPhoto("https://i.im.ge/2024/11/07/kvIgn6.Group-48095491.png")
                .build();
    }
}
