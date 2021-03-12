package by.swaggersample.petstore.service;

import by.swaggersample.petstore.domain.Category;

public interface CategoryService {
    Category createCategory(Category category);
    Category getCategoryById(long id);
}
