package by.swaggersample.petstore.repository;

import by.swaggersample.petstore.domain.Pet;
import by.swaggersample.petstore.domain.PetStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PetRepositoryImpl implements PetRepository {
    List<Pet> petList = new ArrayList<>();

    @Override
    public Pet createPet(Pet pet) {
        petList.add(pet);
        return pet;
    }

    @Override
    public Pet getPetById(long id) {
        for (Pet pet : petList) {
            if (pet.getId() == id){
                return pet;
            }
        }
        return null;
    }

    @Override
    public Pet updatePet(long id, Pet currentPet) {
        for (int i = 0; i < petList.size(); i++) {
            if (petList.get(i).getId() == id){
                petList.set(i, currentPet);
                return currentPet;
            }
        }
        return null;
    }

    @Override
    public void updateImage(long id, String urlImage) {
        for (Pet pet : petList) {
            if (pet.getId() == id){
                pet.setUrlImage(urlImage);
                break;
            }
        }
    }

    @Override
    public void deletePetById(long id) {
        for (Pet pet : petList) {
            if (pet.getId() == id){
                petList.remove(pet);
                break;
            }
        }
    }

    @Override
    public List<Pet> getPetsByStatus(PetStatus petStatus) {
        List<Pet> resultList = new ArrayList<>();
        for (Pet pet : petList) {
            if (pet.getPetStatus().equals(petStatus)){
                resultList.add(pet);
            }
        }
        return resultList;
    }

    @Override
    public boolean containsById(long id) {
        for (Pet pet : petList) {
            if (pet.getId() == id){
                return true;
            }
        }
        return false;
    }
}
