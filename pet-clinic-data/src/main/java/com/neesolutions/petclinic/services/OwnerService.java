package com.neesolutions.petclinic.services;

import com.neesolutions.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}
