package com.example.investlab.view.usecase.impl;

import com.example.investlab.controller.request.UserRequest;
import com.example.investlab.model.dto.UserDTO;
import com.example.investlab.view.service.InsertUserService;
import com.example.investlab.view.service.VerifyUserService;
import com.example.investlab.view.usecase.CreateUserUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateUserUsecaseIMPL implements CreateUserUsecase {

    private final InsertUserService insertUserService;
    private final VerifyUserService verifyUserService;
    private final UserDTO userDTO;

    @Override
    public void signIn(UserRequest userRequest) {
        verifyUserService.userExists(userRequest.getUuid());
        var user = userDTO.toUser(userRequest);
        insertUserService.insertUser(user);
    }

}