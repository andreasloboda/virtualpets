package com.andy.virtualpet.services;

import org.springframework.http.ResponseEntity;

import com.andy.virtualpet.dtos.DtoGetPet;

public interface PetServices {

	ResponseEntity<?> getPetByName(String nn);

	ResponseEntity<?> deletePet(Integer id);

	ResponseEntity<?> editPet(Integer id, DtoGetPet petEdit);

	ResponseEntity<?> getPetById(Integer id);

	ResponseEntity<?> getAllPets();

	ResponseEntity<?> makeNewPet(DtoGetPet petNew);

	ResponseEntity<?> disownPet(Integer id);

}
