package by.swaggersample.petstore.repository;

import by.swaggersample.petstore.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    List<User> userList = new ArrayList<>();

    @Override
    public User createUser(User user) {
        userList.add(user);
        return user;
    }

    @Override
    public List<User> createWithArray(User[] users) {
        userList.addAll(Arrays.asList(users));
        return userList;
    }

    @Override
    public List<User> createWithList(List<User> users) {
        userList.addAll(users);
        return userList;
    }

    @Override
    public void deleteUserByUserName(String userName) {
        for (User user : userList) {
            if (user.getUserName().equals(userName)){
                userList.remove(user);
                break;
            }
        }
    }

    @Override
    public User updateUserByUserName(String userName, User currentUser) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserName().equals(userName)){
                userList.set(i, currentUser);
                return currentUser;
            }
        }
        return null;
    }

    @Override
    public User getUserByUserName(String userName) {
        for (User user : userList) {
            if (user.getUserName().equals(userName)){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userList);
    }

    @Override
    public boolean containsByUserName(String userName) {
        for (User user : userList) {
            if (user.getUserName().equals(userName)){
                return true;
            }
        }
        return false;
    }
}
