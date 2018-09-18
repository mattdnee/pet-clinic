package com.neesolutions.petclinic.repositories;

import com.neesolutions.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
