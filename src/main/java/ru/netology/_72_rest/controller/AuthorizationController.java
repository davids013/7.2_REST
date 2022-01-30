package ru.netology._72_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.netology._72_rest.domain.Authorities;
import ru.netology._72_rest.domain.Item;
import ru.netology._72_rest.domain.User;
import ru.netology._72_rest.service.AuthorizationService;

import javax.validation.Valid;
import java.util.List;

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

    @PostMapping("/post")
    public String postItem(@Valid @RequestBody Item item) {
        System.out.println(item);
        return item.toString();
    }
}
