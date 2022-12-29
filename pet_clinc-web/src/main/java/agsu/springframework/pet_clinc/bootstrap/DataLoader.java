package agsu.springframework.pet_clinc.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import agsu.springframework.pet_clinc.model.Owner;
import agsu.springframework.pet_clinc.model.Pet;
import agsu.springframework.pet_clinc.model.PetType;
import agsu.springframework.pet_clinc.model.Speciality;
import agsu.springframework.pet_clinc.model.Vet;
import agsu.springframework.pet_clinc.services.OwnerService;
import agsu.springframework.pet_clinc.services.PetTypeService;
import agsu.springframework.pet_clinc.services.SpecialityService;
import agsu.springframework.pet_clinc.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialtyService ) {
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.ownerService = ownerService;
        this.specialityService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        dog = petTypeService.save(dog);

        Speciality dentist = new Speciality();
        dentist.setDescription("Desntista");
        specialityService.save(dentist);
        
        Speciality traumatologist = new Speciality();
        traumatologist.setDescription("Traumatologo");
        specialityService.save(traumatologist);

        Owner owner1 = new Owner();
        owner1.setFirstName("Antonio");
        owner1.setLastName("Banderas");
        owner1.setAddres("Pesebre");
        owner1.setCity("MVD");
        owner1.setTelphone("phone");

        Pet pet1 = new Pet();
        pet1.setName("La mascota");
        pet1.setBirthDate(LocalDate.now());
        pet1.setOwner(owner1);
        pet1.setPetType(dog);
        owner1.getPets().add(pet1);

        ownerService.save(owner1);
        
        Owner owner2 = new Owner();
        owner2.setFirstName("Carlos Maria");
        owner2.setLastName("Morales");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("El perro Cusco");
        vet1.setLastName("de Antonio");
        vet1.getSpecialities().add(dentist);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("El cocodrilo");
        vet2.setLastName("de cascarilla");
        vet2.getSpecialities().add(traumatologist);
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
    
}
