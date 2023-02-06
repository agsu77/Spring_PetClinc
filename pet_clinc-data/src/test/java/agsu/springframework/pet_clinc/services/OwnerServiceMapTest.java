package agsu.springframework.pet_clinc.services;

import agsu.springframework.pet_clinc.model.Owner;
import agsu.springframework.pet_clinc.services.map.OwnerServiceMap;
import agsu.springframework.pet_clinc.services.map.PetServiceMap;
import agsu.springframework.pet_clinc.services.map.PetTypeServiceMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OwnerServiceMapTest {

    OwnerServiceMap ownerService;
    
    private final Long idOwner = 1L;

    @BeforeEach
    void setUp(){
        ownerService = new OwnerServiceMap(new PetServiceMap(), new PetTypeServiceMap());
        ownerService.save(Owner.builder().id(idOwner).lastName("Antonio").build());
    }
    
    @Test
    void findAll(){
        Set<Owner> ownerSet = ownerService.findAll();
        assertEquals(idOwner, ownerSet.size());
    }

    @Test
    void findById(){
        Owner owner =  ownerService.findById(idOwner);
        assertEquals(idOwner, owner.getId());
    }

    @Test
    void saveExistinId(){
    	Owner owner = Owner.builder().id(2L).build(); 
    	Owner ownerSaved = ownerService.save(owner);
    	assertEquals(owner.getId(), ownerSaved.getId());
    }
    
    @Test
    void saveNoId(){
    	Owner owner = Owner.builder().build(); 
    	Owner ownerSaved = ownerService.save(owner);
    	
    	assertNotNull(ownerSaved);
    	assertNotNull(ownerSaved.getId());
    }

    @Test
    void delete(){
    	ownerService.delete(ownerService.findById(idOwner));
    	assertEquals(0, ownerService.findAll().size());
    }

    @Test
    void deleteById(){
    	ownerService.deleteById(idOwner);
    	assertEquals(0, ownerService.findAll().size());
    }

    @Test
    void findByLastName(){
    	Owner owner = ownerService.findByLastName("Antonio");
        assertNotNull(owner);
    	assertEquals("Antonio", owner.getLastName());
    }

    @Test
    void findByLastNameNotFound(){
    	Owner owner = ownerService.findByLastName("Nombre");
        assertNull(owner);
    }
}
