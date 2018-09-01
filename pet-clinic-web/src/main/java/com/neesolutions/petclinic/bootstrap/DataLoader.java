package com.neesolutions.petclinic.bootstrap;

import com.neesolutions.petclinic.model.Owner;
import com.neesolutions.petclinic.model.Vet;
import com.neesolutions.petclinic.services.OwnerService;
import com.neesolutions.petclinic.services.VetService;
import com.neesolutions.petclinic.services.map.OwnerServiceMap;
import com.neesolutions.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService  = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner adam = new Owner();
        adam.setId(1L);
        adam.setLastName("Adams");
        adam.setFirstName("Adam");

        Owner bob = new Owner();
        bob.setId(2L);
        bob.setLastName("Billingsly");
        bob.setFirstName("Bob");

        System.out.println("Saving owners... ");
        ownerService.save(adam);
        ownerService.save(bob);

        Vet charlie = new Vet();
        charlie.setId(3L);
        charlie.setLastName("Charles");
        charlie.setFirstName("Charlie");

        Vet david = new Vet();
        david.setId(4L);
        david.setLastName("Davidson");
        david.setFirstName("David");

        System.out.println("Saving vets... ");
        vetService.save(charlie);
        vetService.save(david);

        System.out.println("Done saving data");
    }
}
