package by.swaggersample.petstore;

import by.swaggersample.petstore.domain.User;
import by.swaggersample.petstore.repository.UserRepository;
import by.swaggersample.petstore.repository.jpa.UserDataRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryIntegrationTest {

    private User save = new User("test", "test", "test", "test@mail.com", "Test", "123", 1);

    @Autowired
    private UserDataRepository userRepository;

//    @Before(value = "wtf")
//    public void init(){
//        userRepository.save(new User("test", "test", "test", "test@mail.com", "Test", "123", 1));
//        userRepository.save(new User("test2", "test2", "test2", "test2@mail.com", "Test2", "123", 1));
//    }

    @Test
    @Order(1)
    public void testSave(){
        userRepository.save(save);
        User test = userRepository.getByUserName("test");
        assertEquals(save, test);
    }

    @Test
    @Order(2)
    public void testGetByUserName(){
        userRepository.save(save);
        User save = new User(2L, "test", "test", "test", "test@mail.com", "Test", "123", 1);
        User test = userRepository.getByUserName("test");
        assertEquals(save, test);
    }


    @Test
    @Order(4)
    public void testGetOne(){
        userRepository.save(save);
        User save = new User(4L, "test", "test", "test", "test@mail.com", "Test", "123", 1);
        User one = userRepository.getOne(4L);
        assertEquals(save, one);
    }

    @Test
    @Order(3)
    public void testDeleteByUserName(){
        userRepository.save(save);
        userRepository.deleteByUserName("test");
        User test = userRepository.getByUserName("test");
        assertNull(test);
    }

}
