package com.example.investlab.view.client.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.HashMap;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MarketplaceDataResponse {

    private AdditionalData aditionalData;
    private double rentability;
    private HashMap<String, Double> historicalData;
    private double stockCotation;
}
