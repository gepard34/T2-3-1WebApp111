package ru.nikita.crud_app.dao;

import ru.nikita.crud_app.model.User;

import java.util.List;

public interface UserDao {
    void create(User user);
    void edit(User user);
    void delete(int id);
    User show(int id);
    List<User> index();
}
