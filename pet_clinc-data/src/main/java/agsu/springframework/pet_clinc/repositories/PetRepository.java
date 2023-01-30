package agsu.springframework.pet_clinc.repositories;

import org.springframework.data.repository.CrudRepository;

import agsu.springframework.pet_clinc.model.Pet;

public interface PetRepository extends CrudRepository<Pet,Long>{
    
}
