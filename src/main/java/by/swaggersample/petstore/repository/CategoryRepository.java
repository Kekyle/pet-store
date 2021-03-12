package by.swaggersample.petstore.repository;

import by.swaggersample.petstore.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository {
    Category createCategory(Category category);
    Category getCategoryById(long id);
    boolean containsById(long id);
}
