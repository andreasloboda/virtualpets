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

import com.andy.virtualpet.dtos.DtoGetAdoptable;
import com.andy.virtualpet.services.AdoptableServices;

@RestController
public class AdoptablesController {

	@Autowired
	private AdoptableServices adoptServ;
	
	// Make new
	@PostMapping("/adoptables/")
	public ResponseEntity<?> makeNew(@RequestBody DtoGetAdoptable adoptableNew) {
		return adoptServ.newAdoptable(adoptableNew);
	}

	// Get all
	@GetMapping("/adoptables/")
	public ResponseEntity<?> getAll() {
		return adoptServ.getAllAdoptables();
	}

	// Get one
	@GetMapping("/adoptables/id/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id) {
		return adoptServ.getOneAdoptable(id);
	}

	// Edit one
	@PutMapping("/adoptables/id/{id}")
	public ResponseEntity<?> editOne(@PathVariable Integer id, @RequestBody DtoGetAdoptable adoptableEdit) {
		return adoptServ.editAdoptable(id, adoptableEdit);
	}

	// Delete one
	@DeleteMapping("/adoptables/id/{id}")
	public ResponseEntity<?> deleteOne(@PathVariable Integer id) {
		return adoptServ.deleteAdoptable(id);
	}
	
	//Get All Pets of this type
	@GetMapping("/adoptables/pets/{id}")
	public ResponseEntity<?> getPetsOfType(@PathVariable Integer id) {
		return adoptServ.getPetsOfType(id);
	}
}
