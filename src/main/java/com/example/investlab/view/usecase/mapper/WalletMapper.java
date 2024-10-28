package com.example.investlab.view.usecase.mapper;

import com.example.investlab.model.entitys.Stock;
import com.example.investlab.view.client.response.Wallet;
import com.example.investlab.view.client.response.WalletList;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public WalletList mapToWalletList(Map<String, Map<String, Stock>> source) {
        WalletList walletList = new WalletList();
        List<Wallet> wallets = new ArrayList<>();

        for (Map.Entry<String, Map<String, Stock>> entry : source.entrySet()) {
            String walletName = entry.getKey();
            Map<String, Stock> stocksMap = entry.getValue();

            Wallet wallet = new Wallet();
            wallet.setName(walletName);

            List<Stock> stocksWithSuffix = new ArrayList<>();
            for (Stock stock : stocksMap.values()) {
                Stock modifiedStock = new Stock();
                modifiedStock.setTicker(stock.getTicker() + ".SA");
                modifiedStock.setQuantity(stock.getQuantity());
                modifiedStock.setAveragePrice(stock.getAveragePrice());
                stocksWithSuffix.add(modifiedStock);
            }

            wallet.setItems(stocksWithSuffix);
            wallets.add(wallet);
        }

        walletList.setWallets(wallets);
        return walletList;
    }

    public Map<String, Map<String, Stock>> mapToSource(WalletList walletList) {
        Map<String, Map<String, Stock>> source = new HashMap<>();

        for (Wallet wallet : walletList.getWallets()) {
            String walletName = wallet.getName();
            Map<String, Stock> stocksMap = new HashMap<>();

            for (Stock stock : wallet.getItems()) {
                Stock modifiedStock = new Stock();
                String originalTicker = stock.getTicker().replace(".SA", "");
                modifiedStock.setTicker(originalTicker);
                modifiedStock.setQuantity(stock.getQuantity());
                modifiedStock.setAveragePrice(stock.getAveragePrice());
                stocksMap.put(originalTicker, modifiedStock);
            }

            source.put(walletName, stocksMap);
        }

        return source;
    }

}
