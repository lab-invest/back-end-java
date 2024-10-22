package com.example.investlab.controller.entrypoint;

import com.example.investlab.controller.contract.UpdateUrlContract;
import com.example.investlab.view.usecase.UpdateNameUseCase;
import com.example.investlab.view.usecase.UpdateUrlUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/updateUrl")
@RequiredArgsConstructor
public class UpdateUrlController implements UpdateUrlContract {

    private final UpdateUrlUseCase updateUrlUseCase;

    @Override
    @PatchMapping
    public ResponseEntity<String> updateUrl(@RequestParam String uuid, @RequestParam String name) {
        updateUrlUseCase.updateUrl(uuid, name);
        return new ResponseEntity<>("Url Updated!", HttpStatus.OK);
    }

}
