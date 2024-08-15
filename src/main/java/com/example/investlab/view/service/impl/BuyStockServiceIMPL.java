package com.example.investlab.view.service.impl;

import com.example.investlab.controller.request.StockRequest;
import com.example.investlab.model.dto.StockDTO;
import com.example.investlab.model.entitys.Stock;
import com.example.investlab.model.entitys.User;
import com.example.investlab.model.repository.UserRepository;
import com.example.investlab.utils.Utils;
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
        boolean stockExists = findOrCreateStock(user.getEmail(),"geral", stockRequest);
        if (stockExists){
            var stock = getStockByTicker(user.getEmail(), stockRequest.getTicker()).get();
            var newQuantity = utils.calculateNewQuantity(stockRequest.getQuantity(), stock.getQuantity());
            double totalPrice = utils.calculateTotalPrice(stock.getQuantity(), stock.getAveragePrice()) + utils.calculateTotalPrice(stockRequest.getQuantity(), stockRequest.getAveragePrice());
            double avgPrice = utils.calculateAveragePrice(newQuantity, totalPrice);
            stock.setQuantity(newQuantity);
            stock.setAveragePrice(avgPrice);
            userRepository.updateStockQuantityAndAveragePrice(user.getEmail(), "geral", stock, stock.getTicker());
            return;
        }
        var stock = stockDTO.toStock(stockRequest);
        userRepository.addStockToWallet(user.getEmail(), "geral", stock);
    }

    @Override
    public void addStockToSpecificWallet(User user, StockRequest stockRequest, String walletName) {

    }

    private boolean findOrCreateStock(String email, String walletName, StockRequest stockRequest) {
        var user = userRepository.countByWalletNameAndStockTicker(email, walletName, stockRequest.getTicker());
        return user.isPresent();
        }
    private Optional<Stock> getStockByTicker(String email, String ticker) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        return userOptional.flatMap(user ->
                user.getWallets().stream()
                        .findFirst()
                        .flatMap(wallet ->
                                wallet.getStockList().stream()
                                        .filter(stock -> stock.getTicker().equals(ticker))
                                        .findFirst()
                        )
        );
    }
}
