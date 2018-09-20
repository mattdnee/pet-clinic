package com.neesolutions.petclinic.services.map;

import com.neesolutions.petclinic.model.Visit;
import com.neesolutions.petclinic.services.PetService;
import com.neesolutions.petclinic.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

    private final PetService petService;

    public VisitServiceMap(@Autowired PetService petService) {
        this.petService = petService;
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {
        if(visit.getPet().getOwner() == null || visit.getPet().getOwner().getId() == null ||
                visit.getPet() == null  ||visit.getPet().getId() == null)
            throw new RuntimeException("Invalid Visit");
        return super.save(visit);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
