package com.example.investlab.utils;

import org.springframework.stereotype.Component;

@Component
public class Utils {

    public double calculateAveragePrice(int quantity, double totalPrice){
        return totalPrice / quantity;
    }

    public double calculateTotalPrice(int quantity, double price){
        return quantity * price;
    }
    public int calculateNewQuantity(int quantity, int inc){
        return quantity + inc;
    }
}
