package com.example.investlab.controller.entrypoint;

import com.example.investlab.controller.contract.UserInfoContract;
import com.example.investlab.model.entitys.Stock;
import com.example.investlab.model.entitys.User;
import com.example.investlab.model.entitys.UserResponse;
import com.example.investlab.view.usecase.UserInfoUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserInfoController implements UserInfoContract {

    private final UserInfoUsecase userInfoUsecase;

    @Override
    @GetMapping
    public ResponseEntity<UserResponse> getUserInfo(@RequestParam String uuid) {
        var user = userInfoUsecase.getUserInfo(uuid);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    @GetMapping("/balance")
    public ResponseEntity<Double> getUserBalance(@RequestParam String uuid) {
        var user = userInfoUsecase.getUserBalance(uuid);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    @GetMapping("/wallets")
    public ResponseEntity<Map<String, Map<String, Stock>>> getUserWallets(@RequestParam String uuid) {
        var user = userInfoUsecase.getUserWallets(uuid);
        return ResponseEntity.ok(user);
    }

}
