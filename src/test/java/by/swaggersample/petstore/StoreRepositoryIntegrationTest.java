package by.swaggersample.petstore;
import by.swaggersample.petstore.domain.Order;
import by.swaggersample.petstore.domain.Status;
import by.swaggersample.petstore.repository.jpa.StoreDataRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StoreRepositoryIntegrationTest {

    private Order order = new Order(1, 1, new Date(1008802651329L), Status.APPROVED, true);

    @Autowired
    private StoreDataRepository storeDataRepository;

    @Test
    public void saveTest(){
        storeDataRepository.save(order);
        Order one = storeDataRepository.getOne(1L);
        assertEquals(order, one);
    }
}
