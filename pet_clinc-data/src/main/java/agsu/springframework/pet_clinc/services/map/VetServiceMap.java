package agsu.springframework.pet_clinc.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import agsu.springframework.pet_clinc.model.Speciality;
import agsu.springframework.pet_clinc.model.Vet;
import agsu.springframework.pet_clinc.services.SpecialityService;
import agsu.springframework.pet_clinc.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialtyService) {
        this.specialityService = specialtyService;
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialities() != null && !object.getSpecialities().isEmpty()){
            for (Speciality speciality : object.getSpecialities()) {
                if(speciality.getId() == null){
                    Speciality specialitySaved = specialityService.save(speciality);
                    speciality.setId(specialitySaved.getId());
                }
            }
        }
        return super.save(object);
    }

}
