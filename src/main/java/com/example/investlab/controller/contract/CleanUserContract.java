package com.example.investlab.controller.contract;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Interface que define os contratos e a documentação para a API de resetar usuário.
 */
public interface CleanUserContract {
    /**
     * Reseta um usuário com base no endereço de uuid fornecido.
     *
     * @param uuid do usuário a ser resetado.
     * @return Um {@link ResponseEntity} contendo uma mensagem de sucesso e o status HTTP.
     */
    ResponseEntity<String> cleanUser(@RequestParam String uuid);
}
