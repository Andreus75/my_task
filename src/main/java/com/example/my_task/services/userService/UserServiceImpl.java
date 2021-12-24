package com.example.my_task.services.userService;

import com.example.my_task.dao.UserDao;
import com.example.my_task.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser(User user) {
        if (user != null) {
            userDao.save(user);
        }
    }

    @Override
    public Optional<User> findUserById(int user_id) {
        Optional<User> user = userDao.findById(user_id);
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = (List<User>) userDao.findAll();
        return users;
    }

    @Override
    public void deleteUserById(int user_id) {
        userDao.deleteById(user_id);
    }
}
