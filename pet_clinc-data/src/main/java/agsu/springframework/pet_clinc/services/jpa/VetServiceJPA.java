package agsu.springframework.pet_clinc.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import agsu.springframework.pet_clinc.model.Vet;
import agsu.springframework.pet_clinc.repositories.VetRepository;
import agsu.springframework.pet_clinc.services.VetService;

@Service
@Profile("springdatajpa")
public class VetServiceJPA implements VetService{

    public final VetRepository vetRepository;

    public VetServiceJPA(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }
    
    
}
