package com.example.investlab.view.usecase.impl;

import com.example.investlab.view.service.CleanUserService;
import com.example.investlab.view.service.DeleteUserService;
import com.example.investlab.view.usecase.CleanUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CleanUserUsecaseIMPL implements CleanUserUseCase {

    private final CleanUserService cleanUserService;

    @Override
    public void cleanUser(String uuid) {
        cleanUserService.cleanUser(uuid);
    }
}
