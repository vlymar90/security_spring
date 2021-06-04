package com.gb.lymar.security_spring.controller;

import com.gb.lymar.security_spring.service.ScopeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController()
@RequestMapping("api/v1/app/scope")
@AllArgsConstructor
public class ScopeController {
    private ScopeService scopeService;
    @GetMapping("/inc")
    public boolean scopeInc(Principal principal) {
        return scopeService.incScope(principal.getName());
    }

    @GetMapping("/dec")
    public boolean scopeDec(Principal principal) {
        return scopeService.descScope(principal.getName());
    }

    @GetMapping("/get/current")
    public Integer getScopeInputUser(Principal principal) {
        return scopeService.getMyScope(principal.getName());
    }

    @GetMapping("/get/{id}")
    public Integer getScopeUserId(@PathVariable Long id) {
        return scopeService.getScopeUser(id);
    }
}
