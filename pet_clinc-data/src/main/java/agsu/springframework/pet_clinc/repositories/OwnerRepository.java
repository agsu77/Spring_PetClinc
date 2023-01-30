package agsu.springframework.pet_clinc.repositories;

import org.springframework.data.repository.CrudRepository;

import agsu.springframework.pet_clinc.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    
    Owner findByLastName(String lastName);

}
