package by.bsu.service;

import by.bsu.entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);

    User getUserById(long id);

    User getUserByEmail (String email);

    void delete(long id);

    User editUser(User user);

    List<User> getAll();
}
