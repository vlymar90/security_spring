package com.gb.lymar.security_spring.repository;

import com.gb.lymar.security_spring.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUserName(String username);

}
