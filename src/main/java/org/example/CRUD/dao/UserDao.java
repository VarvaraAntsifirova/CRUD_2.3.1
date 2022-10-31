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

 /*   public void createTable() {
        EntityManager entityManager = entityManagerfactory.createEntityManager();
        entityManager.createNativeQuery("create table Users(" +
                "id integer primary key auto_increment," +
                "firstName varchar(20)," +
                "lastName varchar(30)," +
                "age int);");
    }*/

    public List<User> getAllUsers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<User> userList = entityManager.createNativeQuery("SELECT * FROM users  ", User.class).getResultList();
        return userList;
    }

    public void createUser(String firstName, String lastName, int age) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.createNativeQuery("insert into Users values firstName, lastName, age;");
    }

    public void deleteUser(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.createNativeQuery("delete u from User u where id= :id;")
                .setParameter("id", id);
    }

    public void updateUser() {

    }
}
