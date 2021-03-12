package by.swaggersample.petstore.resource;

import by.swaggersample.petstore.domain.Token;
import by.swaggersample.petstore.domain.User;
import by.swaggersample.petstore.resource.exception.LoginException;
import by.swaggersample.petstore.service.TokenService;
import by.swaggersample.petstore.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/user")
@Slf4j
public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        log.info("method createUser has started with user id=" + user.getId()
                + " username=" + user.getUserName()
                + " password=" + user.getPassword()
                + " firstName=" + user.getFirstName()
                + " lastName=" + user.getLastName()
                + " email=" + user.getEmail()
                + " phone=" + user.getPhone()
                + " status=" + user.getUserStatus());
        return userService.createUser(user);
    }

    @PostMapping(path = "/createWithArray")
    public List<User> createWithArray(@Valid @RequestBody User[] users) {
        log.info("method createWithArray has started");
        for (User user : users) {
            log.debug("user:" + user.getId()
                    + " username=" + user.getUserName()
                    + " password=" + user.getPassword()
                    + " firstName=" + user.getFirstName()
                    + " lastName=" + user.getLastName()
                    + " email=" + user.getEmail()
                    + " phone=" + user.getPhone()
                    + " status=" + user.getUserStatus());
        }
        return userService.createWithArray(users);
    }

    @PostMapping(path = "/createWithList")
    public List<User> createWithList(@Valid @RequestBody List<User> users) {
        log.info("method createWithList has started");
        for (User user : users) {
            log.debug(user.toString());
        }
        return userService.createWithList(users);
    }

    @GetMapping(path = "/login")
    public String login(String userName, String password) {
        log.info("method login has started username = " + userName + " password = " + password);
        User userByUserName = userService.getUserByUserName(userName);
        if (userByUserName.getPassword().equals(password)) {
            UUID token = UUID.randomUUID();
            log.debug("UUID = " + token.toString());
            tokenService.saveToken(new Token(userByUserName.getUserName(), token.toString()));
            return token.toString();
        }
        throw new LoginException("Check login or Password");
    }

    @Transactional
    @GetMapping(path = "/logout")
    public void logout(String userName) {
        log.info("method logout has started");
        tokenService.deleteToken(userName);
    }

    @Transactional
    @DeleteMapping(path = "/{userName}")
    public void deleteUserByUserName(@PathVariable String userName) {
        log.info("method deleteUserByUserName has started with username = " + userName);
        userService.deleteUserByUserName(userName);
    }

    @PutMapping(path = "/update")
    public User updateUserByUserName(@Valid @RequestBody User user) {
        log.info("method update has started with user: " + user.toString());
        return userService.updateUserByUserName(user);
    }

    @GetMapping(path = "/{userName}")
    public User getUserByUserName(@PathVariable String userName) {
        log.info("method getUserByUserName has started + with username = " + userName);
        return userService.getUserByUserName(userName);
    }

    @GetMapping(path = "/getAll")
    public List<User> getAllUsers() {
        log.info("method getAllUsers has started");
        return userService.getAllUsers();
    }
}
