package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    void saveUser(User user);

    User getUserById(int id);

    void deleteUser(int id);
}
