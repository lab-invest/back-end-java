package com.example.investlab.view.client;

import com.example.investlab.view.client.response.MarketplaceDataResponse;
import com.example.investlab.view.client.response.PrevisionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "BFF", url = "${bff.url}")
public interface BffClient {

    @GetMapping("/stock/")
    double getActualCotation(@RequestParam("ticker") String ticker);

    @GetMapping("/stockList")
    List<Double> getCotationList();

    @GetMapping("/stock/prevision")
    PrevisionResponse getStockPrevision(@RequestParam("ticker") String ticker);

    @GetMapping("/stock/marketplace")
    MarketplaceDataResponse getStockMarketplace(@RequestParam("ticker") String ticker);

    @GetMapping("/stock/stockPage")
    void getStockPage(@RequestParam("ticker") String ticker);
}
