package org.example.CRUD.Services;

import org.example.CRUD.dao.UserDao;
import org.example.CRUD.models.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void createUser(String firstName, String lastName, int age) {
        userDao.createUser(firstName, lastName, age);
    }

    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    public void updateUser(){
        userDao.updateUser();
    }
}
