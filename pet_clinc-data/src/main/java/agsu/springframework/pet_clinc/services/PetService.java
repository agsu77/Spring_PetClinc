package agsu.springframework.pet_clinc.services;

import java.util.Set;

import agsu.springframework.pet_clinc.model.Pet;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet onwer);

    Set<Pet> findAll();
}
