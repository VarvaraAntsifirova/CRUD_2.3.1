package org.example.CRUD.dao;

import org.example.CRUD.models.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Component
public class UserDao {

    private final EntityManagerFactory entityManagerFactory;

    public UserDao(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


    public List<User> getAllUsers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<User> list = entityManager.createQuery("SELECT u FROM User u ", User.class).getResultList();
        return list;
    }

    public void createUser(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    public void deleteUser(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(showUser(id)) ? showUser(id) : entityManager.merge(showUser(id)));
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    public void updateUser(int id, User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User userToBeUpdate = showUser(id);
        userToBeUpdate.setFirstName(user.getFirstName());
        userToBeUpdate.setLastName(user.getLastName());
        userToBeUpdate.setAge(user.getAge());
        entityManager.merge(userToBeUpdate);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    public User showUser(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(User.class, id);
    }

}
