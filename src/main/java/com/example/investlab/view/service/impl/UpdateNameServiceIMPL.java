package com.example.investlab.view.service.impl;


import com.example.investlab.model.repository.UserRepository;
import com.example.investlab.view.exception.UserDeletionException;
import com.example.investlab.view.service.UpdateNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateNameServiceIMPL implements UpdateNameService {

    private final UserRepository userRepository;

    @Override
    public void updateName(String uuid, String name) {

        if (userRepository.findByUuid(uuid).isPresent()) {
            userRepository.updateName(uuid, name);
            return;
        }

        throw new UserDeletionException("Fail to update user name with uuid: " + uuid);

    }
}
