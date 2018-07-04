package com.szalaynb.NudgeYourMind.auth;

import com.szalaynb.NudgeYourMind.model.User;
import com.szalaynb.NudgeYourMind.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BulentUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Cannot find username: " + username);
        }
        return new BulentUserPrincipal(user);
    }

    public BulentUserDetailsService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;


    }
}
