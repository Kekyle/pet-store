package by.swaggersample.petstore;
import by.swaggersample.petstore.domain.Tag;
import by.swaggersample.petstore.domain.Token;
import by.swaggersample.petstore.repository.jpa.TagDataRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TagRepositoryIntegrationTest {

    private Tag tag = new Tag("tag");

    @Autowired
    private TagDataRepository tagDataRepository;

    @Test
    @Order(1)
    public void testSave(){
        tagDataRepository.save(tag);
        Tag one = tagDataRepository.getOne(1L);
        assertEquals(tag, one);
    }

    @Test
    @Order(2)
    public void testGetOne(){
        tagDataRepository.save(tag);
        Tag save = new Tag(2L, "tag");
        Tag one = tagDataRepository.getOne(2L);
        assertEquals(save, one);
    }

    @Test
    @Order(3)
    public void testDeleteTag(){
        tagDataRepository.save(tag);
        tagDataRepository.deleteByName("tag");
        Tag test = tagDataRepository.getByName("tag");
        assertNull(test);
    }

}
