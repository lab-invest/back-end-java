package com.example.investlab.controller.entrypoint;


import com.example.investlab.controller.contract.UpdateNameContract;
import com.example.investlab.view.usecase.UpdateNameUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/updateName")
@RequiredArgsConstructor
public class UpdateNameController implements UpdateNameContract {

    private final UpdateNameUseCase updateNameUseCase;

    @Override
    @PatchMapping
    public ResponseEntity<String> updateName(@RequestParam String uuid, @RequestParam String name) {
        updateNameUseCase.updateName(uuid, name);
        return new ResponseEntity<>("Name Updated!", HttpStatus.OK);
    }
}
