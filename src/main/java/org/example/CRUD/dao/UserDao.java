package org.example.CRUD.dao;

import org.example.CRUD.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager ;

    public List<User> getAllUsers() {
        return entityManager
                .createQuery("SELECT u FROM User u ", User.class).getResultList();
    }

    public void createUser(User user) {
        entityManager.persist(user);
    }

    public void deleteUser(int id) {
        entityManager.remove(entityManager.contains(showUser(id)) ? showUser(id) : entityManager.merge(showUser(id)));
    }

    public void updateUser(int id, User user) {
        User userToBeUpdate = showUser(id);
        userToBeUpdate.setFirstName(user.getFirstName());
        userToBeUpdate.setLastName(user.getLastName());
        userToBeUpdate.setAge(user.getAge());
        entityManager.merge(userToBeUpdate);
    }

    public User showUser(int id) {
        return entityManager.find(User.class, id);
    }

}
