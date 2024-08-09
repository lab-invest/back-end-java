package com.example.investlab.controller.entrypoint;

import com.example.investlab.controller.contract.SignInContract;
import com.example.investlab.controller.request.UserRequest;
import com.example.investlab.view.usecase.CreateUserUsecase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class SignInController implements SignInContract {

    private final CreateUserUsecase createUserService;

    @Override
    @PostMapping
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRequest user) {
        createUserService.signIn(user);
        return new ResponseEntity<>("User created!", HttpStatus.CREATED);
    }
}
