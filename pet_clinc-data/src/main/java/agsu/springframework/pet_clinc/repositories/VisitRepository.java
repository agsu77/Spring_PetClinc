package agsu.springframework.pet_clinc.repositories;

import org.springframework.data.repository.CrudRepository;

import agsu.springframework.pet_clinc.model.Visit;

public interface VisitRepository extends CrudRepository<Visit,Long>{
    
}
