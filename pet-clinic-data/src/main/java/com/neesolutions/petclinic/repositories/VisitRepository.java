package com.neesolutions.petclinic.repositories;

import com.neesolutions.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
