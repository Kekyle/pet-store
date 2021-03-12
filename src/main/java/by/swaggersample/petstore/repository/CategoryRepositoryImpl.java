package by.swaggersample.petstore.repository;

import by.swaggersample.petstore.domain.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    List<Category> categoryList = new ArrayList<>();

    @Override
    public Category createCategory(Category category) {
        categoryList.add(category);
        return category;
    }

    @Override
    public Category getCategoryById(long id) {
        for (Category category : categoryList) {

            if (category.getId() == id){
                return category;
            }
        }
        return null;
    }

    @Override
    public boolean containsById(long id) {
        for (Category category : categoryList) {
            if (category.getId() == id){
                return true;
            }
        }
        return false;
    }
}
