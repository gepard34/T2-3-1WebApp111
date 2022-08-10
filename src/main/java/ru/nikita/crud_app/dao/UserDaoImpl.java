package ru.nikita.crud_app.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.nikita.crud_app.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void create(User user) {
        entityManager.persist(user);
    }

    @Transactional
    public void edit(User user) {
        entityManager.merge(user);
    }

    @Transactional
    public void delete(int id) {
        User userToDelete = entityManager.find(User.class, id);
        entityManager.remove(userToDelete);
    }

    @Transactional
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    public List<User> index() {
        return entityManager.createQuery("SELECT User from User u", User.class).getResultList();
    }
}
