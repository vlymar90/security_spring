package com.gb.lymar.security_spring.service;

import com.gb.lymar.security_spring.model.Scope;
import com.gb.lymar.security_spring.model.User;
import com.gb.lymar.security_spring.repository.ScopeRepository;
import com.gb.lymar.security_spring.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ScopeService {
    private ScopeRepository scopeRepository;
    private UserRepository userRepository;

    public boolean incScope(String userName) {
        Scope scope = getScope(userName);
        scope.setScope(scope.getScope() + 1);
        scopeRepository.save(scope);
        return true;
    }

    public boolean descScope(String userName) {
        Scope scope = getScope(userName);
        scope.setScope(scope.getScope() - 1);
        scopeRepository.save(scope);
        return true;
    }

    public Integer getMyScope(String userName) {
       return getScope(userName).getScope();
    }

    public Integer getScopeUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(NoSuchFieldError::new);
        return user.getScope().getScope();
    }

    private Scope getScope(String userName) {
        Optional<User> optional = userRepository.findByUserName(userName);
        User user = optional.get();
        Scope scope = user.getScope();
        return scope;
    }
}
