package com.example.investlab.view.client;

import com.example.investlab.model.entitys.Stock;
import com.example.investlab.model.entitys.UserResponse;
import com.example.investlab.view.client.response.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

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
    StockPageResponse getStockPage();

    @GetMapping("/stock/image")
    String getStockImage(@RequestParam("ticker") String ticker);

    @GetMapping("/stock/comparison")
    Object getStockComparison(@RequestParam("tickerList") List<String> tickerList);

    @PostMapping("/stock/comparisonAside")
    Object getStockComparisonAside(@RequestBody() List<Stock> tickerList);

    @PostMapping("/wallet/comparison")
    Object getWalletComparison(WalletList walletList);

    @PostMapping("/wallet/rentability")
    double updateWalletRentability(@RequestBody List<Stock> tickerList);

    @PostMapping("/wallet/info")
    UserResponse.Wallets getWalletInfo(@RequestBody WalletList walletList);

    @GetMapping("/stock/findStock")
    Object findStock(@RequestParam String stockName);
}
