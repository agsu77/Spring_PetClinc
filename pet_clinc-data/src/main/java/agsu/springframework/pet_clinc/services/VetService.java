package agsu.springframework.pet_clinc.services;

import java.util.Set;

import agsu.springframework.pet_clinc.model.Vet;

public interface VetService {
    
    Vet findById(Long id);

    Vet save(Vet onwer);

    Set<Vet> findAll();
}
