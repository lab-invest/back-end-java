package com.example.investlab.controller.contract;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface UpdateNameContract {

    /**
     * Altera o nome do usuário com base no endereço de uuid fornecido.
     *
     * @param uuid do usuário a ser resetado.
     * @return Um {@link ResponseEntity} contendo uma mensagem de sucesso e o status HTTP.
     */
    ResponseEntity<String> updateName(@RequestParam String uuid, @RequestParam String name);
}
