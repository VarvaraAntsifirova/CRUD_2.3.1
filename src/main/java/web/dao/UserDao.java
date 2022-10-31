package web.dao;

import web.models.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Component
public class UserDao {

    private EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("java.web.config.WebConfig");

 /*   public void createTable() {
        EntityManager entityManager = entityManagerfactory.createEntityManager();
        entityManager.createNativeQuery("create table Users(" +
                "id integer primary key auto_increment," +
                "firstName varchar(20)," +
                "lastName varchar(30)," +
                "age int);");
    }*/

    public List<User> getAllUsers() {
        EntityManager entityManager = entityManagerfactory.createEntityManager();
        List<User> userList = entityManager.createQuery("select u from User u").getResultList();
        return userList;
    }

    public void createUser(String firstName, String lastName, int age) {
        EntityManager entityManager = entityManagerfactory.createEntityManager();
        entityManager.createNativeQuery("insert into Users values firstName, lastName, age;");
    }

    public void deleteUser(int id) {
        EntityManager entityManager = entityManagerfactory.createEntityManager();
        entityManager.createNativeQuery("delete u from User u where id= :id;")
                .setParameter("id", id);
    }

    public void updateUser() {

    }
}
