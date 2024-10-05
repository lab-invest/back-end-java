package com.example.investlab.controller.entrypoint;

import com.example.investlab.controller.contract.BuyStockContract;
import com.example.investlab.controller.request.StockRequest;
import com.example.investlab.view.usecase.BuyStockUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class BuyStockController implements BuyStockContract {

    private final BuyStockUsecase buyStockUsecase;

    @Override
    @PatchMapping
    public ResponseEntity<String> buyStock(
            @RequestParam String uuid,
            @RequestBody StockRequest stock,
            @RequestParam(required = false) String wallet
    ) {
        buyStockUsecase.buyStock(uuid, stock, wallet);
        return ResponseEntity.ok("Stock purchased successfully");
    }
}
