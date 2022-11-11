package agsu.springframework.pet_clinc.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import agsu.springframework.pet_clinc.model.Owner;
import agsu.springframework.pet_clinc.services.OwnerService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    public OwnerServiceMap() {
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findByLastName(String lastName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Owner save(Owner object) {
        System.out.println("Guardando un OWNER...");
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}
