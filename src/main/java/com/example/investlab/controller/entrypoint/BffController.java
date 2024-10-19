package com.example.investlab.controller.entrypoint;

import com.example.investlab.controller.request.StockRequest;
import com.example.investlab.view.client.BffClient;
import com.example.investlab.view.client.response.MarketplaceDataResponse;
import com.example.investlab.view.client.response.PrevisionResponse;
import com.example.investlab.view.client.response.StockPageResponse;
import com.example.investlab.view.client.response.WalletComparisonResponse;
import com.example.investlab.view.usecase.BuyStockUsecase;
import com.example.investlab.view.usecase.UserInfoUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bff")
public class BffController {

    private final BffClient bffClient;
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

//    @GetMapping("wallet/comparison")
//    public ResponseEntity<List<WalletComparisonResponse>> getWalletComparison(
//            @RequestParam String uuid
//    ) {
//        var walletsList = userInfoUsecase.getUserWallets(uuid);
//        var response = bffClient.getWalletComparison(walletsList);
//        return ResponseEntity.ok(response);
//    }
}
