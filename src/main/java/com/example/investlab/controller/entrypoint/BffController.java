package com.example.investlab.controller.entrypoint;

import com.example.investlab.controller.mapper.StockMapper;
import com.example.investlab.controller.request.StockRequest;
import com.example.investlab.model.entitys.Stock;
import com.example.investlab.view.client.BffClient;
import com.example.investlab.view.client.response.*;
import com.example.investlab.view.usecase.BuyStockUsecase;
import com.example.investlab.view.usecase.UserInfoUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bff")
public class BffController {

    private final BffClient bffClient;
    private final StockMapper mapper;
    private final UserInfoUsecase userInfoUsecase;

    @GetMapping("stock/cotation")
    public ResponseEntity<Double> getStockCotation(
            @RequestParam String ticker
    ) {
        var cotation = bffClient.getActualCotation(ticker);
        return ResponseEntity.ok(cotation);
    }

    @GetMapping("stock/rentability/list")
    public ResponseEntity<List<Double>> getStockListCotation(
    ) {
        var rentabilityList = bffClient.getCotationList();
        return ResponseEntity.ok(rentabilityList);
    }

    @GetMapping("stock/prevision")
    public ResponseEntity<PrevisionResponse> getStockPrevision(
            @RequestParam String ticker
    ) {
        var prevision = bffClient.getStockPrevision(ticker);
        return ResponseEntity.ok(prevision);
    }

    @GetMapping("stock/marketplace")
    public ResponseEntity<MarketplaceDataResponse> getStockMarketPlace(
            @RequestParam String ticker
    ) {
        var response = bffClient.getStockMarketplace(ticker);
        return ResponseEntity.ok(response);
    }

    @GetMapping("stock/stockpage")
    public ResponseEntity<StockPageResponse> getStockPage() {
        var stockPage = bffClient.getStockPage();
        return ResponseEntity.ok(stockPage);
    }

    @GetMapping("stock/image")
    public ResponseEntity<String> getStockImage(
            @RequestParam String ticker
    ) {
        var image = bffClient.getStockImage(ticker);
        return ResponseEntity.ok(image);
    }

    @GetMapping("stock/comparison")
    public ResponseEntity<Object> getStockComparison(
            @RequestParam List<String> ticker
    ) {
        var comparison = bffClient.getStockComparison(ticker);
        return ResponseEntity.ok(comparison);
    }

    @GetMapping("stock/comparison/aside")
    public ResponseEntity<Object> getStockComparison(
            @RequestParam String uuid,
            @RequestParam(required = false) String wallet
    ) {
        var walletList = userInfoUsecase.getUserWallet(uuid, wallet);
        var comparison = bffClient.getStockComparisonAside(mapper.convertToStockList(walletList));
        return ResponseEntity.ok(comparison);
    }

    @GetMapping("wallet/comparison")
    public ResponseEntity<Object> getWalletComparison(
            @RequestParam String uuid
    ) {
        var walletsList = userInfoUsecase.getUserWallets(uuid);
//        return ResponseEntity.ok(mapToWalletList(walletsList));
        var response = bffClient.getWalletComparison(mapToWalletList(walletsList));
        return ResponseEntity.ok(response);
    }

    public WalletList mapToWalletList(Map<String, Map<String, Stock>> source) {
        WalletList walletList = new WalletList();
        List<Wallet> wallets = new ArrayList<>();

        for (Map.Entry<String, Map<String, Stock>> entry : source.entrySet()) {
            String walletName = entry.getKey();
            Map<String, Stock> stocksMap = entry.getValue();

            Wallet wallet = new Wallet();
            wallet.setName(walletName);

            List<Stock> stocksWithSuffix = new ArrayList<>();
            for (Stock stock : stocksMap.values()) {
                Stock modifiedStock = new Stock();
                modifiedStock.setTicker(stock.getTicker() + ".SA");
                modifiedStock.setQuantity(stock.getQuantity());
                modifiedStock.setAveragePrice(stock.getAveragePrice());
                stocksWithSuffix.add(modifiedStock);
            }

            wallet.setItems(stocksWithSuffix);
            wallets.add(wallet);
        }

        walletList.setWallets(wallets);
        return walletList;
    }
}
