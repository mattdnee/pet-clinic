package com.neesolutions.petclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {
    private Set<Specialty> specialties;

    public Vet(){
        specialties = new HashSet<Specialty>();
    }

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }
}
