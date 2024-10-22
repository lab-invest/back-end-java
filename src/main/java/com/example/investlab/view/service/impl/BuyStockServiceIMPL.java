package com.example.investlab.view.service.impl;

import com.example.investlab.controller.request.StockRequest;
import com.example.investlab.model.dto.StockDTO;
import com.example.investlab.model.entitys.Stock;
import com.example.investlab.model.entitys.User;
import com.example.investlab.model.repository.UserRepository;
import com.example.investlab.utils.Utils;
import com.example.investlab.view.exception.InsufficientStockQuantityException;
import com.example.investlab.view.service.BuyStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuyStockServiceIMPL implements BuyStockService {

    private final UserRepository userRepository;
    private final StockDTO stockDTO;
    private final Utils utils;
    @Override
    public void addStockToWallet(User user, StockRequest stockRequest) {
        boolean stockExists = findOrCreateStock(user.getUuid(), "geral", stockRequest);
        if (stockExists) {
            handleExistingStock(user, stockRequest, "geral");
        } else {
            addNewStockToWallet(user, stockRequest, "geral");
        }
    }

    private void handleExistingStock(User user, StockRequest stockRequest, String wallet) {
        var stockOptional = getStockByTicker(user, wallet, stockRequest.getTicker());
        if (stockOptional.isPresent()) {
            var stock = stockOptional.get();
            var newQuantity = utils.calculateNewQuantity(stockRequest.getQuantity(), stock.getQuantity());
            if (newQuantity < 0) {
                throw new InsufficientStockQuantityException("Stock quantity insufficient");
            }
            double totalPrice = calculateTotalPrice(stockRequest, stock, newQuantity);
            if (newQuantity == 0) {
                userRepository.deleteStockFromWallet(user.getEmail(), wallet, stock.getTicker());
                userRepository.deleteStockFromGeral(user.getEmail(), stock.getTicker());
            } else {
                double avgPrice = utils.calculateAveragePrice(newQuantity, totalPrice);
                userRepository.updateStockQuantityAndAveragePrice(user.getEmail(), wallet, stock.getTicker(), newQuantity, avgPrice);
            }
        }
    }

    private void addNewStockToWallet(User user, StockRequest stockRequest, String wallet) {
        var stock = stockDTO.toStock(stockRequest);
        userRepository.addStockToWallet(user.getEmail(), wallet, stock.getTicker(), stock);
    }

    private double calculateTotalPrice(StockRequest stockRequest, Stock stock, double newQuantity) {
        double currentStockTotal = utils.calculateTotalPrice(stock.getQuantity(), stock.getAveragePrice());
        double newStockTotal = utils.calculateTotalPrice(stockRequest.getQuantity(), stockRequest.getAveragePrice());
        return currentStockTotal + newStockTotal;
    }

    @Override
    public void addStockToSpecificWallet(User user, StockRequest stockRequest, String wallet) {
        boolean stockExistsInSpecific = findOrCreateStock(user.getUuid(), wallet, stockRequest);
        boolean stockExistsInGeneral = findOrCreateStock(user.getUuid(), "geral", stockRequest);

        if (stockExistsInSpecific) {
            handleExistingStock(user, stockRequest, wallet);
        } else {
            addNewStockToWallet(user, stockRequest, wallet);
        }

        if (stockExistsInGeneral) {
            handleExistingStock(user, stockRequest, "geral");
        } else {
            addNewStockToWallet(user, stockRequest, "geral");
        }
    }


    private boolean findOrCreateStock(String uuid, String walletName, StockRequest stockRequest) {
        Optional<User> userOptional = userRepository.findByUuid(uuid);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getWallets().containsKey(walletName) &&
                    user.getWallets().get(walletName).containsKey(stockRequest.getTicker());
        }
        return false;
    }



        private Optional<Stock> getStockByTicker(User user, String walletName, String ticker) {
        var wallet = user.getWallets().get(walletName);
        return wallet != null ? Optional.ofNullable(wallet.get(ticker)) : Optional.empty();
    }
}
