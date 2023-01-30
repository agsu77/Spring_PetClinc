package agsu.springframework.pet_clinc.services.jpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import agsu.springframework.pet_clinc.model.Owner;
import agsu.springframework.pet_clinc.repositories.OwnerRepository;
import agsu.springframework.pet_clinc.repositories.PetRepository;
import agsu.springframework.pet_clinc.repositories.PetTypeRepository;
import agsu.springframework.pet_clinc.services.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerServiceJPA  implements OwnerService{

    public final OwnerRepository ownerRepository;
    public final PetRepository petRepository;
    public final PetTypeRepository petTypeRepository;

    public OwnerServiceJPA(OwnerRepository ownerRepository, PetRepository petRepository,
            PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findById(Long id) {
        Optional<Owner> opOwner = ownerRepository.findById(id);
        if(opOwner.isPresent()){
            return opOwner.get();
        }else{
            return null;
        }
    }

    @Override
    public Owner save(Owner object) {
        Owner ownerSaved = ownerRepository.save(object);
        return ownerSaved;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
    
}
