package by.swaggersample.petstore.service;

import by.swaggersample.petstore.domain.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    List<User> createWithArray(User[] users);

    List<User> createWithList(List<User> users);

    void deleteUserByUserName(String userName);

    User updateUserByUserName(User user);

    User getUserByUserName(String userName);

    List<User> getAllUsers();
}
