package com.example.investlab.controller.entrypoint;

import com.example.investlab.controller.contract.DeleteUserContract;
import com.example.investlab.view.usecase.DeleteUserUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class DeleteUserController implements DeleteUserContract {
    private final DeleteUserUsecase deleteUserUsecase;

    @Override
    @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestParam String uuid) {
        deleteUserUsecase.deleteUser(uuid);
        return new ResponseEntity<>("User deleted!", HttpStatus.OK);
    }
}

