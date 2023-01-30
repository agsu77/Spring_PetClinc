package agsu.springframework.pet_clinc.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import agsu.springframework.pet_clinc.model.Pet;
import agsu.springframework.pet_clinc.model.Visit;
import agsu.springframework.pet_clinc.repositories.PetRepository;
import agsu.springframework.pet_clinc.services.VisitService;

@Service
@Profile({"default","map"})
public class VisitServiceMap extends AbstractMapService<Visit,Long> implements VisitService{

    private final PetRepository petRepository;

    public VisitServiceMap(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit object) {
        if(object.getPet() != null && object.getPet().getId() == null){
            Pet pet = object.getPet();
            Pet petSaved = petRepository.save(object.getPet());
            pet.setId(petSaved.getId());
        }
        return super.save(object);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
    
}
