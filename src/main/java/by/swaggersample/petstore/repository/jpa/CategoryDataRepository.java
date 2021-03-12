package by.swaggersample.petstore.repository.jpa;

import by.swaggersample.petstore.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDataRepository extends JpaRepository<Category, Long> {
    void deleteByName(String name);
    Category getByName(String name);
}
