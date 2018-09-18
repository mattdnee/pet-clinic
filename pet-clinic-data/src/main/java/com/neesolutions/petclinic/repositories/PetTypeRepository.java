package com.neesolutions.petclinic.repositories;

import com.neesolutions.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
