package ru.netology._72_rest.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.netology._72_rest.domain.Authorities;
import ru.netology._72_rest.domain.User;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final Map<String, User> users = new ConcurrentHashMap<>();

    public UserRepository(@Value("#{new Boolean('${custom.is-test:false}')}") boolean isTest) {
//        Добавление тестового пользователя
        if (isTest) {
            users.put("test", new User("test", "test", List.of(Authorities.READ)));
        }
        System.out.println(this + " run in test mode: " + isTest);
    }

    public List<Authorities> getUserAuthorities(User user) {
        final String name = user.getName();
        if (users.containsKey(name) && users.get(name).getPassword().equals(user.getPassword())) {
            return users.get(name).getAuthorities();
        }
        return null;
    }
}
