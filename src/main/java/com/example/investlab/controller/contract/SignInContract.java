package com.example.investlab.controller.contract;

import com.example.investlab.controller.request.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Interface que define os contratos e a documentação para a API de criação de usuário.
 */
public interface SignInContract {

    /**
     * Cria um novo usuário com base nas informações fornecidas.
     *
     * @param user Objeto {@link UserRequest} contendo os dados do novo usuário.
     * @return Um {@link ResponseEntity} contendo uma mensagem de sucesso e o status HTTP.
     */
    ResponseEntity<String> registerUser(@RequestBody UserRequest user);
}

