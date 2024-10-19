package com.example.investlab.controller.contract;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface UpdateUrlContract {

    /**
         * Altera a url do usuário com base no endereço de uuid fornecido.
            *
            * @param uuid do usuário a ser resetado.
            * @return Um {@link ResponseEntity
    } contendo uma mensagem de sucesso e o status HTTP.
     */
    ResponseEntity<String> updateUrl(@RequestParam String uuid, @RequestParam String name);
}
