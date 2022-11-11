package agsu.springframework.pet_clinc.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import agsu.springframework.pet_clinc.model.Owner;
import agsu.springframework.pet_clinc.model.Vet;
import agsu.springframework.pet_clinc.services.OwnerService;
import agsu.springframework.pet_clinc.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService ) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Antonio");
        owner1.setLastName("Banderas");

        ownerService.save(owner1);
        
        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Carlos Maria");
        owner2.setLastName("Morales");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("El perro Cusco");
        vet1.setLastName("de Antonio");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(1L);
        vet2.setFirstName("El cocodrilo");
        vet2.setLastName("de cascarilla");
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
    
}
