package com.neesolutions.petclinic.services.springdatajpa;

import com.neesolutions.petclinic.model.Owner;
import com.neesolutions.petclinic.repositories.OwnerRepository;
import com.neesolutions.petclinic.repositories.PetRepository;
import com.neesolutions.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerServiceSDJpaTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerServiceSDJpa ownerServiceSDJpa;

    final String last_name = "Smith";
    Owner returnOwner;

    @BeforeEach
    void setUp(){
        returnOwner = Owner.builder().id(1L).lastName(last_name).build();
    }

    @Test
    void findByLastName() {

        //given
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        //when
        Owner smith = ownerServiceSDJpa.findByLastName(last_name);

        //then
        assertEquals(last_name, smith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnerSet = new HashSet<>();
        returnOwnerSet.add(Owner.builder().id(1L).build());
        returnOwnerSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnOwnerSet);

        Set<Owner> owners = ownerServiceSDJpa.findAll();

        assertNotNull(owners);
        assertEquals(returnOwnerSet.size(), owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = ownerServiceSDJpa.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(1L)).thenReturn(Optional.empty());

        Owner owner = ownerServiceSDJpa.findById(1L);

        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner= ownerServiceSDJpa.save(ownerToSave);

        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerServiceSDJpa.delete(returnOwner);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerServiceSDJpa.deleteById(1L);
        verify(ownerRepository, times(1)).deleteById(anyLong());
    }
}