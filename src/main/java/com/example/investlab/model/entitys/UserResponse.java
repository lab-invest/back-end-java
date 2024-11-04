package com.example.investlab.model.entitys;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserResponse {
    private String cpf;
    private String uuid;
    private String name;
    private String email;
    private String password;
    private LocalDate birthDate;
    private double balance;
    private Wallets wallets;
    private double rentability;
    private String userPhoto;

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Wallets {
        private List<Wallet> wallets;
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Wallet {
        private String name;
        private double total;
        private double rentability;
        private List<Item> items;
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item {
        private String ticker;
        private int quantity;
        private String stockImg;
    }
}
