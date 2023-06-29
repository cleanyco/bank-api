package com.cleanyco.bankapi.service;

import com.cleanyco.bankapi.data.User;
import com.cleanyco.bankapi.database.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findUserByUsername(username);
    }

    public boolean isUsernameUnique(String username) {
        User user = repository.findUserByUsername(username);
        return user == null;
    }

    public boolean isEmailUnique(String email) {
        User user = repository.findUserByUsername(email);
        return user == null;
    }
}
