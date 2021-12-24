package com.example.my_task.services.userService;

import com.example.my_task.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveUser(User user);
    Optional<User> findUserById(int user_id);
    List<User> findAllUsers();
    void deleteUserById(int user_id);
}
