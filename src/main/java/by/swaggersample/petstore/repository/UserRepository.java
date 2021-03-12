package by.swaggersample.petstore.repository;

import by.swaggersample.petstore.domain.User;

import java.util.List;

public interface UserRepository {
    User createUser(User user);

    List<User> createWithArray(User[] users);

    List<User> createWithList(List<User> users);

    void deleteUserByUserName(String userName);

    User updateUserByUserName(String userName, User user);

    User getUserByUserName(String userName);

    List<User> getAllUsers();

    boolean containsByUserName(String userName);
}
