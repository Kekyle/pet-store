package by.swaggersample.petstore;
import by.swaggersample.petstore.domain.Category;
import by.swaggersample.petstore.domain.Pet;
import by.swaggersample.petstore.domain.PetStatus;
import by.swaggersample.petstore.domain.Tag;
import by.swaggersample.petstore.repository.jpa.PetDataRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetRepositoryIntegrationTest {

    private Tag[] tags = new Tag[]{new Tag("tag1")};
    private Category category = new Category("category1");
    private List<Tag> tagList = Arrays.asList(tags);
    private Pet pet = new Pet("test", "image", category, tagList, PetStatus.AVAILABLE);

    @Autowired
    private PetDataRepository petDataRepository;

    @Test
    public void saveTest(){
        petDataRepository.save(pet);
        Pet one = petDataRepository.getOne(1L);
        assertEquals(pet, one);
    }

}
