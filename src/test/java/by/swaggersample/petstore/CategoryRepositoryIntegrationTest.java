package by.swaggersample.petstore;

import by.swaggersample.petstore.domain.Category;
import by.swaggersample.petstore.domain.Tag;
import by.swaggersample.petstore.repository.jpa.CategoryDataRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoryRepositoryIntegrationTest {

    private Category category = new Category("test");

    @Autowired
    private CategoryDataRepository categoryDataRepository;

    @Test
    @Order(1)
    public void testSave(){
        categoryDataRepository.save(category);
        Category one = categoryDataRepository.getOne(1L);
        assertEquals(category, one);
    }

    @Test
    @Order(2)
    public void testGetOne(){
        categoryDataRepository.save(category);
        Category save = new Category(2L, "test");
        Category one = categoryDataRepository.getOne(2L);
        assertEquals(save, one);
    }

    @Test
    @Order(3)
    public void testDeleteCategory(){
        categoryDataRepository.save(category);
        categoryDataRepository.deleteByName("test");
        Category test = categoryDataRepository.getByName("test");
        assertNull(test);
    }
}
