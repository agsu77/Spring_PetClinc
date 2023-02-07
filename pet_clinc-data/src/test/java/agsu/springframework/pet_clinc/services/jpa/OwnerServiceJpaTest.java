package agsu.springframework.pet_clinc.services.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import agsu.springframework.pet_clinc.model.Owner;
import agsu.springframework.pet_clinc.repositories.OwnerRepository;
import agsu.springframework.pet_clinc.repositories.PetRepository;
import agsu.springframework.pet_clinc.repositories.PetTypeRepository;

@ExtendWith(MockitoExtension.class)
public class OwnerServiceJpaTest {
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerServiceJPA service;

    Owner returnOwner;

    @BeforeEach
    void setUp(){
        returnOwner = Owner.builder().id(1L).lastName("Antonio").build();
        // ownerService = new OwnerServiceJpa(new PetServiceMap(), new PetTypeServiceMap());
        // ownerService.save(Owner.builder().id(idOwner).lastName("Antonio").build());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        Owner owner = service.findById(1L);
        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = service.findById(2L);
        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();
        when(ownerRepository.save(any())).thenReturn(returnOwner);
        Owner ownerSaved = service.save(ownerToSave);
        assertNotNull(ownerSaved);
    }

    @Test
    void findAll() {
        Set<Owner> returnOwners = new HashSet<>();
        returnOwners.add(Owner.builder().id(1L).build());
        returnOwners.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnOwners);

        Set<Owner> owners = service.findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void delete() {
        service.delete(returnOwner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(ownerRepository).deleteById(any());
    }

    @Test
    void findByLastName() {
        String lastName = "Antonio";
        returnOwner = Owner.builder().id(1L).lastName(lastName).build();
        when(ownerRepository.findByLastName(lastName)).thenReturn(returnOwner);

        Owner antonio = service.findByLastName(lastName);

        assertEquals(lastName, antonio.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    
    
}
