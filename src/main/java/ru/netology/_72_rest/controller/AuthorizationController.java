package ru.netology._72_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology._72_rest.domain.Authorities;
import ru.netology._72_rest.domain.User;
import ru.netology._72_rest.service.AuthorizationService;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/")
public class AuthorizationController {
    private final AuthorizationService service;

    @Autowired
    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }
}
