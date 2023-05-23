package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();

    void saveUser(User user);

    User getUserById(int id);

    void deleteUser(int id);
}
