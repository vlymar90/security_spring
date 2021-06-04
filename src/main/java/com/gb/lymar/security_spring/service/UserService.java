package com.gb.lymar.security_spring.service;

import com.gb.lymar.security_spring.model.Roles;
import com.gb.lymar.security_spring.model.User;
import com.gb.lymar.security_spring.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;

    public Optional<User> findByUsername(String name) {
        return userRepository.findByUserName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    User user = findByUsername(s).orElseThrow(() ->
            new UsernameNotFoundException("Invalid username or password"));
    return new org.springframework.security.core
            .userdetails.User(user.getUserName(),
            user.getPassword(), mapRolesToAuthorities(user.getRolesList()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(List<Roles> rolesList) {
        return  rolesList.stream().map(roles -> new SimpleGrantedAuthority(roles.getName()))
                .collect(Collectors.toList());
    }
}
