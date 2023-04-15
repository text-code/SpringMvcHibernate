package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl {
    private int USER_ID;
    private final List<User> users;

    public UserDaoImpl() {
        users = new ArrayList<>();
        users.add(new User(++USER_ID, "Eric", 10, "cartman@email.com"));
        users.add(new User(++USER_ID, "Kyle", 10, "broflovski@email.com"));
        users.add(new User(++USER_ID, "Kenny", 10, "mccormick@email.com"));
        users.add(new User(++USER_ID, "Stan", 10, "marsh@email.com"));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUser(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public void save(User user) {
        user.setId(++USER_ID);
        users.add(user);
    }

    public void update(int id, User updateUser) {
        User newUser = getUser(id);

        newUser.setName(updateUser.getName());
        newUser.setAge(updateUser.getAge());
        newUser.setEmail(updateUser.getEmail());
    }

    public void delete(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
