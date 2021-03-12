package by.swaggersample.petstore.resource;

import by.swaggersample.petstore.domain.Category;
import by.swaggersample.petstore.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/category")
@Slf4j
public class CategoryResource {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Category createCategory(@Valid @RequestBody Category category) {
        log.info("method createCategory has started, category: " + category.toString());
        return categoryService.createCategory(category);
    }

    @GetMapping(path = "/{categoryId}")
    public Category getCategoryById(@PathVariable int categoryId) {
        log.info("method getCategoryById has started");
        log.debug("categoryId = " + categoryId);
        return categoryService.getCategoryById(categoryId);
    }

}
