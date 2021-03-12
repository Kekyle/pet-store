package by.swaggersample.petstore;

import by.swaggersample.petstore.domain.User;
import by.swaggersample.petstore.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PetStoreApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
//        User user = new User();
//        user.setUserName("test");
//        userService.createUser(user);
//        User test = userService.getUserByUserName("test");
//        assertEquals(user, test);
    }

}
