package com.example.investlab.model.dto;

import com.example.investlab.controller.request.StockRequest;
import com.example.investlab.controller.request.UserRequest;
import com.example.investlab.model.entitys.Stock;
import com.example.investlab.model.entitys.User;
import com.example.investlab.model.entitys.Wallet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class StockDTO {
    public Stock toStock(StockRequest stockRequest) {
        return Stock.builder()
                .ticker(stockRequest.getTicker())
                .quantity(stockRequest.getQuantity())
                .averagePrice(stockRequest.getAveragePrice())
                .build();
    }
}
