package com.example.investlab.controller.contract;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Interface que define os contratos e a documentação para a API de exclusão de usuário.
 */
public interface DeleteUserContract {

    /**
     * Exclui um usuário com base no endereço de e-mail fornecido.
     *
     * @param email O endereço de e-mail do usuário a ser excluído.
     * @return Um {@link ResponseEntity} contendo uma mensagem de sucesso e o status HTTP.
     */
    ResponseEntity<String> deleteUser(@RequestParam String email);
}
