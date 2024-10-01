package com.example.investlab.controller.entrypoint;

import com.example.investlab.controller.request.StockRequest;
import com.example.investlab.view.client.BffClient;
import com.example.investlab.view.client.response.MarketplaceDataResponse;
import com.example.investlab.view.client.response.PrevisionResponse;
import com.example.investlab.view.usecase.BuyStockUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stock")
public class BffController {

    private final BffClient bffClient;

    @GetMapping("/cotation")
    @Cacheable("dataCache")
    public ResponseEntity<Double> getStockCotation(
            @RequestParam String ticker
    ) {
        var cotation = bffClient.getActualCotation(ticker);
        return ResponseEntity.ok(cotation);
    }

    @GetMapping("cotation/list")
    @Cacheable("dataCache")
    public ResponseEntity<List<Double>> getStockListCotation(
    ) {
        var cotation = bffClient.getCotationList();
        return ResponseEntity.ok(cotation);
    }

    @Cacheable("dataCache")
    @GetMapping("prevision")
    public ResponseEntity<PrevisionResponse> getStockPrevision(
            @RequestParam String ticker
    ) {
        var cotation = bffClient.getStockPrevision(ticker);
        return ResponseEntity.ok(cotation);
    }

    @Cacheable("dataCache")
    @GetMapping("marketplace")
    public ResponseEntity<MarketplaceDataResponse> getStockMarketPlace(
            @RequestParam String ticker
    ) {
        var cotation = bffClient.getStockMarketplace(ticker);
        return ResponseEntity.ok(cotation);
    }
}
