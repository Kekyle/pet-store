package by.swaggersample.petstore.service;

import by.swaggersample.petstore.domain.Pet;
import by.swaggersample.petstore.domain.PetStatus;

import java.util.List;

public interface PetService {
    Pet createPet(Pet pet);

    Pet getPetById(long id);

    Pet updatePet(Pet pet);

    void updateImage(long id, String urlImage);

    void deletePetById(long id);

    List<Pet> getPetsByStatus(PetStatus petStatus);
}
