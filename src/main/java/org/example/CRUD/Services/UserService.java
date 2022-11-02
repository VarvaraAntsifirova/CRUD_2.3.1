package org.example.CRUD.Services;

import org.example.CRUD.dao.UserDao;
import org.example.CRUD.models.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Service
@Transactional
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void createUser(User user) {
        userDao.createUser(user);
    }

    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    public void updateUser(int id, User user) {
        userDao.updateUser(id, user);
    }

    public User showUser(int id) {
        return userDao.showUser(id);
    }
}
