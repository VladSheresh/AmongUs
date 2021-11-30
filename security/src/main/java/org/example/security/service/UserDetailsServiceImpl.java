package org.example.security.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.OurUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsDao userDetailsDao;

    @Override
    public UserDetails loadUserByUsername(String username) {
        OurUser ourUser = Optional.ofNullable(userDetailsDao.getByName(username))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User.builder()
                .username(ourUser.getUsername())
                .password(ourUser.getPassword())
                .roles(ourUser.getRole().toString())
                .build();
    }
}
