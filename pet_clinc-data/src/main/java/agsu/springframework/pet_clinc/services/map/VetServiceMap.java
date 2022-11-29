package agsu.springframework.pet_clinc.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import agsu.springframework.pet_clinc.model.Vet;
import agsu.springframework.pet_clinc.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {

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
        return super.save(object);
    }

}
