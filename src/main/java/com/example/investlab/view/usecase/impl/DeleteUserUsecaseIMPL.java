package com.example.investlab.view.usecase.impl;

import com.example.investlab.view.exception.UserDeletionException;
import com.example.investlab.view.service.DeleteUserService;
import com.example.investlab.view.usecase.DeleteUserUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteUserUsecaseIMPL implements DeleteUserUsecase {

    private final DeleteUserService deleteUserService;

    @Override
    public void deleteUser(String email) {
        deleteUserService.deleteUser(email);
    }
}
