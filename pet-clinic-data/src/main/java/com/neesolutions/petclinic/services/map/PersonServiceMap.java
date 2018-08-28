package com.neesolutions.petclinic.services.map;

import com.neesolutions.petclinic.model.Person;
import com.neesolutions.petclinic.services.CrudService;

import java.util.Set;

public class PersonServiceMap extends AbstractMapService<Person, Long> implements CrudService<Person, Long> {
    @Override
    public Set<Person> findAll() {
        return super.findAll();
    }

    @Override
    public Person findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Person save(Person person) {
        return super.save(person.getId(), person);
    }

    @Override
    public void delete(Person person) {
        super.delete(person);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
