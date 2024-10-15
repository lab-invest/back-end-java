package com.example.investlab.controller.entrypoint;

import com.example.investlab.controller.contract.CleanUserContract;
import com.example.investlab.controller.contract.DeleteUserContract;
import com.example.investlab.view.usecase.CleanUserUseCase;
import com.example.investlab.view.usecase.DeleteUserUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cleanUser")
@RequiredArgsConstructor
public class CleanUserController implements CleanUserContract {
    private final CleanUserUseCase cleanUserUseCase;

    @Override
    @PatchMapping
    public ResponseEntity<String> cleanUser(@RequestParam String uuid) {
        cleanUserUseCase.cleanUser(uuid);
        return new ResponseEntity<>("User cleaned!", HttpStatus.OK);
    }
}

