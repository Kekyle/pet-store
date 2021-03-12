package by.swaggersample.petstore;

import by.swaggersample.petstore.domain.Token;
import by.swaggersample.petstore.domain.User;
import by.swaggersample.petstore.repository.jpa.TokenDataRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TokenRepositoryIntegrationTest {

    private Token token = new Token("test", "test");
    private Token test = new Token("test3", "test");

    @Autowired
    private TokenDataRepository tokenDataRepository;

    @Test
    @Order(1)
    public void testSave(){
        tokenDataRepository.save(token);
        Token one = tokenDataRepository.getOne(1L);
        assertEquals(token, one);
    }

    @Test
    @Order(2)
    public void testGetOne(){
        tokenDataRepository.save(token);
        Token save = new Token(2L, "test", "test");
        Token one = tokenDataRepository.getOne(2L);
        assertEquals(save, one);
    }

    @Test
    @Order(3)
    public void testDeleteToken(){
        tokenDataRepository.save(test);
        tokenDataRepository.deleteByUserName("test3");
        Token test = tokenDataRepository.getByUserName("test3");
        assertNull(test);
    }
}
