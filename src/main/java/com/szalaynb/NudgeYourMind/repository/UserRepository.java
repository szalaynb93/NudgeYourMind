package com.szalaynb.NudgeYourMind.repository;

import com.szalaynb.NudgeYourMind.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
