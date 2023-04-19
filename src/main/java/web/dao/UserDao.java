package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getUser(long id);

    void save(User user);

    void update(User updateUser);

    void delete(long id);
}
