package com.example.investlab.controller.mapper;

import com.example.investlab.model.entitys.Stock;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class StockMapper {
    public List<Stock> convertToStockList(Map<String, Stock> walletList) {
        return walletList.values().stream()
                .map(stock -> Stock.builder()
                        .ticker(stock.getTicker() + ".SA")
                        .quantity(stock.getQuantity())
                        .averagePrice(stock.getAveragePrice())
                        .build())
                .collect(Collectors.toList());
    }
}
