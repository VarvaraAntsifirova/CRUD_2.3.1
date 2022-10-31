package web.services;

import web.dao.UserDao;
import web.models.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    private UserDao userDao;

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
