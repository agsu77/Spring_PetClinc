package agsu.springframework.pet_clinc.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import agsu.springframework.pet_clinc.model.Speciality;
import agsu.springframework.pet_clinc.services.SpecialityService;

@Service
public class SpecialityServiceMap extends AbstractMapService<Speciality,Long> implements SpecialityService{

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }
    
}
