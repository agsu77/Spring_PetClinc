package agsu.springframework.pet_clinc.services;

import java.util.Set;

import agsu.springframework.pet_clinc.model.Owner;

public interface OwnerService {
    
    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner onwer);

    Set<Owner> findAll();

}
