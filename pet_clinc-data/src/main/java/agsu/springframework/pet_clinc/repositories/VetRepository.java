package agsu.springframework.pet_clinc.repositories;

import org.springframework.data.repository.CrudRepository;

import agsu.springframework.pet_clinc.model.Vet;

public interface VetRepository extends CrudRepository<Vet,Long>{
    
}
