package by.swaggersample.petstore.repository.jpa;

import by.swaggersample.petstore.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagDataRepository extends JpaRepository<Tag, Long> {
    void deleteByName(String name);
    Tag getByName(String name);
}
