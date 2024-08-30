package com.example.investlab.view.exception;

public class InsufficientStockQuantityException extends RuntimeException{
    public InsufficientStockQuantityException(String message) {
        super(message);
    }
}
