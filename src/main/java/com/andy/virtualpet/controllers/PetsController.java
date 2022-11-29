package com.andy.virtualpet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.andy.virtualpet.dtos.DtoGetPet;
import com.andy.virtualpet.services.PetServices;

@RestController
public class PetsController {
	
	@Autowired
	private PetServices petServ;
	
	// Make new
	@PostMapping("/pets/")
	public ResponseEntity<?> makeNew(@RequestBody DtoGetPet petNew) {
		return petServ.makeNewPet(petNew);
	}

	// Get all
	@GetMapping("/pets/")
	public ResponseEntity<?> getAll() {
		return petServ.getAllPets();
	}

	// Get one
	@GetMapping("/pets/id/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id) {
		return petServ.getPetById(id);
	}

	// Edit one
	@PutMapping("/pets/id/{id}")
	public ResponseEntity<?> editOne(@PathVariable Integer id, @RequestBody DtoGetPet petEdit) {
		return petServ.editPet(id, petEdit);
	}

	// Delete one
	@DeleteMapping("/pets/id/{id}")
	public ResponseEntity<?> deleteOne(@PathVariable Integer id) {
		return petServ.deletePet(id);
	}

	// Find Pet By Name
	@GetMapping("/pets/name/{nn}")
	public ResponseEntity<?> getPetByName(@PathVariable String nn) {
		return petServ.getPetByName(nn);
	}
	
	// Disown Pet
	@PutMapping("/pets/disown/{id}")
	public ResponseEntity<?> disownPet(@PathVariable Integer id) {
		return petServ.disownPet(id);
	}
}
