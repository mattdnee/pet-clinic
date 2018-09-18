package com.neesolutions.petclinic.repositories;

import com.neesolutions.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
