package agsu.springframework.pet_clinc.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import agsu.springframework.pet_clinc.model.Visit;
import agsu.springframework.pet_clinc.repositories.VisitRepository;
import agsu.springframework.pet_clinc.services.VisitService;

@Service
@Profile("springdatajpa")
public class VisitRepositoryJPA implements VisitService{

    public final VisitRepository visitRepository;

    public VisitRepositoryJPA(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
    

}
