package com.gb.lymar.security_spring.repository;

import com.gb.lymar.security_spring.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Long> {
}
