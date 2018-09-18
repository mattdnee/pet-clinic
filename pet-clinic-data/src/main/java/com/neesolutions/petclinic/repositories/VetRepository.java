package com.neesolutions.petclinic.repositories;

import com.neesolutions.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
