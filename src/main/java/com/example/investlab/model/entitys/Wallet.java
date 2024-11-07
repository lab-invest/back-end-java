package com.example.investlab.model.entitys;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {
    private String name;
    private double total;
    private double rentability;
    private List<Item> items;
}


