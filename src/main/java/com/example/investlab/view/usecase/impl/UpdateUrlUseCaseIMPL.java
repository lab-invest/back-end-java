package com.example.investlab.view.usecase.impl;


import com.example.investlab.view.service.UpdateUrlService;
import com.example.investlab.view.usecase.UpdateUrlUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UpdateUrlUseCaseIMPL implements UpdateUrlUseCase {
    private final UpdateUrlService updateUrlService;

    @Override
    public void updateUrl(String uuid, String dto) {
        updateUrlService.updateUrl(uuid, dto);
    }
}
