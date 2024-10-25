package com.example.investlab.controller.contract;

import com.example.investlab.model.entitys.Stock;
import com.example.investlab.model.entitys.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Interface que define os contratos e a documentação para a API de informações do usuário.
 */
public interface UserInfoContract {

    /**
     * Obtém as informações do usuário com base no endereço de e-mail fornecido.
     *
     * @param email O endereço de e-mail do usuário.
     * @return Um {@link ResponseEntity} contendo um {@link User} e o status HTTP.
     */
    ResponseEntity<Optional<User>> getUserInfo(@RequestParam String email);

    /**
     * Obtém o saldo do usuário com base no endereço de e-mail fornecido.
     *
     * @param email O endereço de e-mail do usuário.
     * @return Um {@link ResponseEntity} contendo o saldo do usuário e o status HTTP.
     */
    ResponseEntity<Double> getUserBalance(@RequestParam String email);

    /**
     * Obtém a lista das carteiras e suas ações com base no endereço de e-mail fornecido.
     *
     * @param email O endereço de e-mail do usuário.
     * @return Um {@link ResponseEntity} contendo a lista de carteiras e o status HTTP.
     */
    ResponseEntity<Map<String, Map<String, Object>>> getUserWallets(@RequestParam String email);
}
