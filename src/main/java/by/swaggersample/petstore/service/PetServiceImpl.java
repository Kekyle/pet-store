package by.swaggersample.petstore.service;

import by.swaggersample.petstore.domain.Category;
import by.swaggersample.petstore.domain.Pet;
import by.swaggersample.petstore.domain.PetStatus;
import by.swaggersample.petstore.domain.Tag;
import by.swaggersample.petstore.repository.jpa.CategoryDataRepository;
import by.swaggersample.petstore.repository.jpa.PetDataRepository;
import by.swaggersample.petstore.repository.jpa.TagDataRepository;
import by.swaggersample.petstore.service.exception.CategoryNotFoundException;
import by.swaggersample.petstore.service.exception.PetNotFoundException;
import by.swaggersample.petstore.service.exception.TagNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PetServiceImpl implements PetService {

    @Autowired
    private PetDataRepository petRepository;

    @Autowired
    private CategoryDataRepository categoryRepository;

    @Autowired
    private TagDataRepository tagRepository;

    @Override
    public Pet createPet(Pet pet) {
        log.info("method createPet has started");
        log.debug("pet : " + pet.toString());
        long categoryId = pet.getCategory().getId();
        if (!categoryRepository.existsById(categoryId)) {
            log.warn("Category not found", new CategoryNotFoundException());
            throw new CategoryNotFoundException("Category not found");
        }
        List<Tag> tags = pet.getTags();
        List<Tag> allTags = new ArrayList<>();
        for (int i = 0; i < tags.size(); i++) {
            if (tags.get(i) == null) break;
            Tag tagById = tagRepository.getOne(tags.get(i).getId());
            if (tagById == null) {
                log.warn("Tag not found");
                throw new TagNotFoundException("Tag not found");
            }
            if (tagRepository.existsById(tagById.getId())) {
                log.debug("method add tag = " + tagById.toString());
                allTags.add(tagById);
            } else {
                log.warn("Tag not found");
                throw new TagNotFoundException("Tag not found");
            }
        }
        Category categoryById = categoryRepository.getOne(categoryId);
        pet.setCategory(categoryById);
        pet.setTags(allTags);
        return petRepository.save(pet);
    }

    @Override
    public Pet getPetById(long id) {
        log.info("method getPetById has started");
        log.debug("id = " + id);
        if (petRepository.existsById(id)) {
            return petRepository.getOne(id);
        }
        throw new PetNotFoundException("Pet not found");
    }

    @Override
    public Pet updatePet(Pet pet) {
        log.info("method updatePet has started");
        log.debug("pet : " + pet.toString());
        if (petRepository.existsById(pet.getId())) {
            return petRepository.save(pet);
        }
        throw new PetNotFoundException("Pet not found");
    }

    @Override
    public void updateImage(long id, String urlImage) {
//        if (petRepository.existsById(id)) {
//            petRepository.updateImage(id, urlImage);
//        } else {
//            throw new PetNotFoundException("Pet not found");
//        }
    }

    @Override
    public void deletePetById(long id) {
        log.info("method deletePetById has started");
        log.debug("id = " + id);
        if (petRepository.existsById(id)) {
            petRepository.deleteById(id);
        } else {
            throw new PetNotFoundException("Pet not found");
        }
    }

    @Override
    public List<Pet> getPetsByStatus(PetStatus petStatus) {
        log.info("method getPetsByStatus has started");
        log.debug("petStatus = " + petStatus.name());
        return petRepository.getAllByPetStatus(petStatus);
    }
}
