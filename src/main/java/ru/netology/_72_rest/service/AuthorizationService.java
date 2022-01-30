package ru.netology._72_rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology._72_rest.domain.Authorities;
import ru.netology._72_rest.domain.User;
import ru.netology._72_rest.exception.InvalidCredentials;
import ru.netology._72_rest.exception.UnauthorizedUser;
import ru.netology._72_rest.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    private final UserRepository userRepository;

    @Autowired
    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        if (isEmpty(user)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Authorization failed for user " + user.getName());
        }
        return userAuthorities;
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(User user) {
        return user == null || user.getName().isEmpty() || user.getPassword().isEmpty();
    }
}