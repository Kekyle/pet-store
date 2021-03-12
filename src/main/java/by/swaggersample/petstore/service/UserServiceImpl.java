package by.swaggersample.petstore.service;

import by.swaggersample.petstore.domain.User;
import by.swaggersample.petstore.repository.jpa.UserDataRepository;
import by.swaggersample.petstore.service.exception.UserIsAlreadyExistException;
import by.swaggersample.petstore.service.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDataRepository userRepository;

    @Override
    public User createUser(User user) {
        log.info("method createUser has started");
        log.debug("user : " + user.toString());
        if (userRepository.existsByUserName(user.getUserName())) {
            log.warn("User is already exist", new UserIsAlreadyExistException());
            throw new UserIsAlreadyExistException("User is already exist");
        } else {
            return userRepository.save(user);
        }
    }

    @Override
    public List<User> createWithArray(User[] users) {
        log.info("method createWithArray has started");
        List<User> userList = Arrays.asList(users);
        for (User user : userList) {
            log.debug("user : " + user.toString());
            if (userRepository.existsByUserName(user.getUserName())) {
                throw new UserIsAlreadyExistException("User is already exist");
            }
        }
        return userRepository.saveAll(userList);
    }

    @Override
    public List<User> createWithList(List<User> users) {
        log.info("method createWithList has started");
        for (User user : users) {
            log.debug("user : " + user.toString());
            if (userRepository.existsByUserName(user.getUserName())) {
                throw new UserIsAlreadyExistException("User is already exist");
            }
        }
        return userRepository.saveAll(users);
    }

    @Override
    public void deleteUserByUserName(String userName) {
        log.info("method deleteUserByUserName has started");
        log.debug("username = " + userName);
        if (userRepository.existsByUserName(userName)) {
            userRepository.deleteByUserName(userName);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    @Override
    public User updateUserByUserName(User user) {
        log.info("method updateUserByUserName has started");
        log.debug("user : " + user.toString());
        if (userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    @Override
    public User getUserByUserName(String userName) {
        log.info("method getUserByUserName has started");
        log.debug("username = " + userName);
        if (userRepository.existsByUserName(userName)) {
            return userRepository.getByUserName(userName);
        }
        throw new UserNotFoundException("User not found");
    }

    @Override
    public List<User> getAllUsers() {
        log.info("method getAllUsers has started");
        return userRepository.findAll();
    }
}
