package com.gb.lymar.security_spring.repository;

import com.gb.lymar.security_spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
