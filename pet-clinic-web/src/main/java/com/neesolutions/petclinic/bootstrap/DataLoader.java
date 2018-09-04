package com.neesolutions.petclinic.bootstrap;

import com.neesolutions.petclinic.model.*;
import com.neesolutions.petclinic.services.OwnerService;
import com.neesolutions.petclinic.services.PetTypeService;
import com.neesolutions.petclinic.services.SpecialtyService;
import com.neesolutions.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        if(petTypeService.findAll().size() == 0)
            loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner adam = new Owner();
        adam.setLastName("Adams");
        adam.setFirstName("Adam");
        adam.setAddress("1 Apple Ave");
        adam.setCity("Applesvile");
        adam.setTelephone("610-123-4567");

        Pet adamsDog = new Pet();
        adamsDog.setPetType(savedDogPetType);
        adamsDog.setOwner(adam);
        adamsDog.setBirthDate(LocalDate.now());
        adamsDog.setName("Aaron");
        adam.getPets().add(adamsDog);

        Owner bob = new Owner();
        bob.setLastName("Billingsly");
        bob.setFirstName("Bob");
        bob.setAddress("1 Banana Blvd");
        bob.setCity("Baltimore");
        bob.setTelephone("610-234-5678");

        Pet bobCat = new Pet();
        bobCat.setPetType(savedDogPetType);
        bobCat.setOwner(adam);
        bobCat.setBirthDate(LocalDate.now());
        bobCat.setName("Bucky");
        bob.getPets().add(bobCat);

        System.out.println("Saving owners... ");
        ownerService.save(adam);
        ownerService.save(bob);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");

        Specialty savedRadiology = specialtyService.save(radiology);
        Specialty savedSurgery = specialtyService.save(surgery);
        Specialty savedDentistry = specialtyService.save(dentistry);

        Vet charlie = new Vet();
        charlie.setLastName("Charles");
        charlie.setFirstName("Charlie");
        charlie.getSpecialties().add(savedRadiology);

        Vet david = new Vet();
        david.setLastName("Davidson");
        david.setFirstName("David");
        david.getSpecialties().add(savedDentistry);

        Vet edward = new Vet();
        edward.setLastName("Edwards");
        edward.setFirstName("Edward");
        edward.getSpecialties().add(savedSurgery);

        System.out.println("Saving vets... ");
        vetService.save(charlie);
        vetService.save(david);

        System.out.println("Done saving data");
    }
}
