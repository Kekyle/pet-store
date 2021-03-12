package by.swaggersample.petstore.service;

import by.swaggersample.petstore.domain.Category;
import by.swaggersample.petstore.repository.CategoryRepository;
import by.swaggersample.petstore.repository.jpa.CategoryDataRepository;
import by.swaggersample.petstore.service.exception.CategoryNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDataRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        log.info("method createCategory has started");
        log.debug("category : " + category.toString());
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(long id) {
        log.info("method getCategoryById has started");
        log.debug("id = " + id);
        if (categoryRepository.existsById(id)) {
            return categoryRepository.getOne(id);
        }
        log.warn("Category not found", new CategoryNotFoundException());
        throw new CategoryNotFoundException("Category not found");
    }
}
