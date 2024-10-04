package com.example.investlab.view.usecase;


import com.example.investlab.view.client.response.CotationResponse;

import java.util.List;
import java.util.Optional;

public interface WalletUseCase {
        List<CotationResponse> getWalletValuation(String uuid);
}
