package com.example.investlab.view.usecase.impl;

import com.example.investlab.view.service.UpdateNameService;
import com.example.investlab.view.usecase.UpdateNameUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UpdateNameUseCaseIMPL implements UpdateNameUseCase {
    private final UpdateNameService updateNameService;

    @Override
    public void updateName(String uuid, String dto) {
        updateNameService.updateName(uuid, dto);
    }
}
