package by.swaggersample.petstore.repository.jpa;

import by.swaggersample.petstore.domain.Pet;
import by.swaggersample.petstore.domain.PetStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetDataRepository extends JpaRepository<Pet, Long> {
    List<Pet> getAllByPetStatus(PetStatus petStatus);
}
