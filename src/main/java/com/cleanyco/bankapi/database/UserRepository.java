package com.cleanyco.bankapi.database;

import com.cleanyco.bankapi.data.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByUsername(String username);

    User findUserByEmail(String email);
}
