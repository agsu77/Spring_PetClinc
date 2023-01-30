package agsu.springframework.pet_clinc.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import agsu.springframework.pet_clinc.model.PetType;
import agsu.springframework.pet_clinc.services.PetTypeService;

@Service
@Profile({"default","map"})
public class PetTypeServiceMap extends AbstractMapService<PetType,Long> implements PetTypeService{

    @Override
    public void delete(PetType object) {
        
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }
    
}
