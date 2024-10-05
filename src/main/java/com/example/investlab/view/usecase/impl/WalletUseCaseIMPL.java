package com.example.investlab.view.usecase.impl;

import com.example.investlab.view.client.response.CotationResponse;
import com.example.investlab.view.usecase.WalletUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WalletUseCaseIMPL implements WalletUseCase {
    @Override
    public List<CotationResponse> getWalletValuation(String uuid) {
        return null;
    }
}
