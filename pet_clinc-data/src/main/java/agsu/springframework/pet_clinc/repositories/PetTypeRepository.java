package agsu.springframework.pet_clinc.repositories;

import org.springframework.data.repository.CrudRepository;

import agsu.springframework.pet_clinc.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType,Long>{
    
}
