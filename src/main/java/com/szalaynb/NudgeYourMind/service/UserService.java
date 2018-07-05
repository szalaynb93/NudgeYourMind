package com.szalaynb.NudgeYourMind.service;

import com.szalaynb.NudgeYourMind.model.UserEntity;
import com.szalaynb.NudgeYourMind.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;

@RepositoryRestResource
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity findById(Long id) {
        return userRepository.findById(id).get();
    }

    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }

    public boolean isUserCountZero() {
        return userRepository.count() == 0;
    }
}
