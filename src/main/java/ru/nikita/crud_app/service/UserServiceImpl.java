package ru.nikita.crud_app.service;

import org.springframework.stereotype.Service;
import ru.nikita.crud_app.dao.UserDao;
import ru.nikita.crud_app.model.User;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public void edit(User user) {
        userDao.edit(user);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public User show(int id) {
        return userDao.show(id);
    }

    @Override
    public List<User> index() {
        return userDao.index();
    }
}
