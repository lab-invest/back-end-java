package com.example.investlab.controller.contract;

import com.example.investlab.controller.request.StockRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Interface que define os contratos e a documentação para a API de compra de ações.
 */
public interface BuyStockContract {

    /**
     * Compra ações com base nas informações fornecidas.
     *
     * @param email Endereço de e-mail do usuário.
     * @param stock Objeto {@link StockRequest} contendo os dados da ação.
     * @param wallet (Opcional) Identificador da carteira do usuário.
     * @return Um {@link ResponseEntity} contendo uma mensagem de sucesso e o status HTTP.
     */
    ResponseEntity<String> buyStock(
            @RequestParam String email,
            @RequestBody StockRequest stock,
            @RequestParam(required = false) String wallet
    );
}

