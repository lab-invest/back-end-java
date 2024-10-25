package com.example.investlab.view.usecase.mapper;

import com.example.investlab.model.entitys.Stock;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class WalletMapper {

    public Map<String, Map<String, Object>> mapWallets(Map<String, Map<String, Stock>> wallets) {
        Map<String, Map<String, Object>> response = new HashMap<>();

        for (Map.Entry<String, Map<String, Stock>> entry : wallets.entrySet()) {
            String walletName = entry.getKey();
            Map<String, Stock> geral = entry.getValue();

            double totalAmount = 0.0;

            for (Stock stock : geral.values()) {
                totalAmount += stock.getQuantity() * stock.getAveragePrice();
            }

            double rentability = 0;

            Map<String, Object> walletData = new HashMap<>();
            walletData.put("stocks", geral);
            walletData.put("rentability", rentability);
            walletData.put("total_amount", totalAmount);

            response.put(walletName, walletData);
        }

        return response;
    }
}
