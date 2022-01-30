package ru.netology._72_rest.repository;

import org.springframework.stereotype.Repository;
import ru.netology._72_rest.domain.Authorities;
import ru.netology._72_rest.domain.User;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final Map<String, User> users = new ConcurrentHashMap<>();

    public List<Authorities> getUserAuthorities(User user) {
////        Добавление тестового пользователя
//        users.put("testUser1", new User(
//                "testUser1", "iddqd", List.of(Authorities.READ, Authorities.WRITE)));
        final String name = user.getName();
        if (users.containsKey(name) && users.get(name).getPassword().equals(user.getPassword())) {
            return users.get(name).getAuthorities();
        }
        return null;
    }
}
