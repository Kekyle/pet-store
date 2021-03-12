package by.swaggersample.petstore.resource;

import by.swaggersample.petstore.domain.Pet;
import by.swaggersample.petstore.domain.PetStatus;
import by.swaggersample.petstore.resource.exception.AccessException;
import by.swaggersample.petstore.service.PetService;
import by.swaggersample.petstore.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/pet")
@Slf4j
public class PetResource {

    @Autowired
    private PetService petService;

    @PostMapping
    public Pet createPet(@Valid @RequestBody Pet pet) {
        log.info("method createPet has started");
        log.debug("Pet: " + pet.toString());
        return petService.createPet(pet);
    }

    @PutMapping(path = "/{petId}/updateImage")
    public void updateImage(@PathVariable int petId, String urlImage) {
        log.info("method updateImage has started");
        log.debug("petId = " + petId + " urlImage = " + urlImage);
        petService.updateImage(petId, urlImage);
    }

    @GetMapping(path = "/{petId}")
    public Pet getPetById(@PathVariable int petId) {
        log.info("method getPetById has started");
        log.debug("petId = " + petId);
        return petService.getPetById(petId);
    }

    @DeleteMapping(path = "/{petId}")
    public void deletePetById(@PathVariable int petId) {
        log.info("method deletePetById has started");
        log.debug("petId = " + petId);
        petService.deletePetById(petId);
    }

    @PutMapping(path = "/update")
    public Pet updatePetById(@Valid @RequestBody Pet pet) {
        log.info("method updatePetById has started");
        log.debug("Pet: " + pet.toString());
        return petService.updatePet(pet);
    }

    @GetMapping(path = "/findByStatus")
    public List<Pet> getPetsByStatus(PetStatus petStatus) {
        log.info("method getPetsByStatus has started");
        log.debug("petStatus = " + petStatus);
        return petService.getPetsByStatus(petStatus);
    }

}
