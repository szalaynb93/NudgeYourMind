package com.szalaynb.NudgeYourMind.repository;

import com.szalaynb.NudgeYourMind.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);
}
