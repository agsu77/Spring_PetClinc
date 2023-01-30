package agsu.springframework.pet_clinc.repositories;

import org.springframework.data.repository.CrudRepository;

import agsu.springframework.pet_clinc.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality,Long>{
    
}
