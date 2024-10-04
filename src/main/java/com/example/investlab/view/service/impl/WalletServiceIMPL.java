package com.example.investlab.view.service.impl;

import com.example.investlab.view.client.BffClient;
import com.example.investlab.view.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WalletServiceIMPL implements WalletService {

    private final BffClient bffClient;

    @Override
    public Double getCotation(String ticker) {
        return bffClient.getActualCotation(ticker);
    }
}
