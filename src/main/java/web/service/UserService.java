package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> listAllUsers();

    User getUserById(int id);

    void addUser(User user);

    void modifyUser(int id, User user);

    void deleteUserById(int id);
}
