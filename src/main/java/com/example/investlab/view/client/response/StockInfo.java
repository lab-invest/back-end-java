package com.example.investlab.view.client.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class StockInfo {
    private String nome;
    private double rentabilidade;
    private String imagem;
    private double max;
    private double minimo;
    private int volume;
    private double abertura;
    private double fechamento;
    private double precoAtual;
}
