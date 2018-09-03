package com.neesolutions.petclinic.bootstrap;

import com.neesolutions.petclinic.model.Owner;
import com.neesolutions.petclinic.model.PetType;
import com.neesolutions.petclinic.model.Vet;
import com.neesolutions.petclinic.services.OwnerService;
import com.neesolutions.petclinic.services.PetTypeService;
import com.neesolutions.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner adam = new Owner();
        adam.setLastName("Adams");
        adam.setFirstName("Adam");

        Owner bob = new Owner();
        bob.setLastName("Billingsly");
        bob.setFirstName("Bob");

        System.out.println("Saving owners... ");
        ownerService.save(adam);
        ownerService.save(bob);

        Vet charlie = new Vet();
        charlie.setLastName("Charles");
        charlie.setFirstName("Charlie");

        Vet david = new Vet();
        david.setLastName("Davidson");
        david.setFirstName("David");

        System.out.println("Saving vets... ");
        vetService.save(charlie);
        vetService.save(david);

        System.out.println("Done saving data");
    }
}
