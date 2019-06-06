package ru.artbmstu.hw6aa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.artbmstu.hw6aa.model.User;
import ru.artbmstu.hw6aa.repository.UserRepository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {

    private static Map<String, User> identityMap = new ConcurrentHashMap<>();

    @Autowired
    UserRepository userRepository;

    public User getUserById(String id) {
        if (identityMap.containsKey(id)) return identityMap.get(id);
        return userRepository.findById(id).orElse(null);
    }

    public void saveUser(User user) {
        identityMap.put(user.getId(), user);
        userRepository.save(user);
    }
}