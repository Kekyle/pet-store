package by.swaggersample.petstore.repository;

import by.swaggersample.petstore.domain.Pet;
import by.swaggersample.petstore.domain.PetStatus;

import java.util.List;

public interface PetRepository {
    Pet createPet(Pet pet);
    Pet getPetById(long id);
    Pet updatePet(long id, Pet pet);
    void updateImage(long id, String urlImage);
    void deletePetById(long id);
    List<Pet> getPetsByStatus(PetStatus petStatus);
    boolean containsById(long id);
}
