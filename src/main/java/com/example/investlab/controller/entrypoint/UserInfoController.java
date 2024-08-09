package com.example.investlab.controller.entrypoint;

import com.example.investlab.controller.contract.UserInfoContract;
import com.example.investlab.model.entitys.User;
import com.example.investlab.view.usecase.UserInfoUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserInfoController implements UserInfoContract {

    private final UserInfoUsecase userInfoUsecase;

    @Override
    @GetMapping
    public ResponseEntity<Optional<User>> getUserInfo(@RequestParam String email) {
        var user = userInfoUsecase.getUserInfo(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    @GetMapping("/balance")
    public ResponseEntity<Double> getUserBalance(@RequestParam String email) {
        var user = userInfoUsecase.getUserBalance(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
