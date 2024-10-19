package com.example.investlab.view.service.impl;

import com.example.investlab.model.repository.UserRepository;
import com.example.investlab.view.exception.UserDeletionException;
import com.example.investlab.view.service.UpdateUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UpdateUrlServiceIMPL implements UpdateUrlService {

    private final UserRepository userRepository;

    @Override
    public void updateUrl(String uuid, String name) {

        if (userRepository.findByUuid(uuid).isPresent()) {
            userRepository.updateUrl(uuid, name);
            return;
        }

        throw new UserDeletionException("Fail to update user url with uuid: " + uuid);


    }

}
