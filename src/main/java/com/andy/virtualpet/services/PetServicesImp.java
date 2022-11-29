package com.andy.virtualpet.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.andy.virtualpet.dtos.DtoGetPet;
import com.andy.virtualpet.dtos.DtoReturnPet;
import com.andy.virtualpet.entities.PetEntity;
import com.andy.virtualpet.repositories.AdoptableRepository;
import com.andy.virtualpet.repositories.PetRepository;
import com.andy.virtualpet.repositories.UserRepository;

@Service
public class PetServicesImp implements PetServices{
	
	@Autowired
	private PetRepository petRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private AdoptableRepository specieRepo;
	@Autowired
	private DTOServices dto;

	@Override
	public ResponseEntity<?> getPetByName(String nn) {
		PetEntity pet = petRepo.findByName(nn).orElse(null);
		if (pet==null)
			return new ResponseEntity<> ("Pet Not Found", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(dto.sendPet(pet), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deletePet(Integer id) {
		if (!petRepo.existsById(id))
			return new ResponseEntity<> ("Pet Not Found", HttpStatus.NOT_FOUND);
		petRepo.deleteById(id);
		return new ResponseEntity<> ("Pet Deleted", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> editPet(Integer id, DtoGetPet petEdit) {
		PetEntity pet = petRepo.findById(id).orElse(null);
		if (pet == null)
			return new ResponseEntity<> ("Pet Not Found", HttpStatus.NOT_FOUND);
		if (petEdit.getName() != null) {
			if (!pet.getName().equalsIgnoreCase(petEdit.getName())) {
				if (petRepo.existsByName(petEdit.getName()))
					return new ResponseEntity<> ("Name already taken", HttpStatus.BAD_REQUEST);
				else
					pet.setName(petEdit.getName());
			}
		}
		if (petEdit.getOwnerId() != null) {
			// IF pet is abandoned	OR	Pet Owner is not same as new owner
			if (pet.getOwner()==null || !(pet.getOwner().getId()==petEdit.getOwnerId())) {
				if (userRepo.existsById(petEdit.getOwnerId()))
					pet.setOwner(userRepo.findById(petEdit.getOwnerId()).orElse(null));
				else
					return new ResponseEntity<> ("Owner not found", HttpStatus.NOT_FOUND);
			}
		}
		if (petEdit.getSpecieId() != null) {
			if (!(pet.getSpecie().getId()==petEdit.getSpecieId())) {
				if (specieRepo.existsById(petEdit.getSpecieId()))
					pet.setSpecie(specieRepo.findById(petEdit.getSpecieId()).orElse(null));
				else
					return new ResponseEntity<> ("Specie not found", HttpStatus.NOT_FOUND);
			}
		}
		return new ResponseEntity<> (dto.sendPet(petRepo.save(pet)), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getPetById(Integer id) {
		if (!petRepo.existsById(id))
			return new ResponseEntity<> ("Pet Not Found", HttpStatus.NOT_FOUND);
		PetEntity pet = petRepo.findById(id).orElse(null);
		return new ResponseEntity<> (dto.sendPet(pet), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getAllPets() {
		List<PetEntity> petList = (List<PetEntity>) petRepo.findAll();
		if (petList.isEmpty())
			return new ResponseEntity<> ("Pets not found", HttpStatus.OK);
		List<DtoReturnPet> response = new ArrayList<>();
		for (PetEntity i : petList)
			response.add(dto.sendPet(i));
		return new ResponseEntity<> (response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> makeNewPet(DtoGetPet petNew) {
		if ((petNew.getOwnerId()==null) || (petNew.getName())==null || (petNew.getSpecieId())==null)
			return new ResponseEntity<> ("Missing information", HttpStatus.BAD_REQUEST);
		if (!userRepo.existsById(petNew.getOwnerId()))
			return new ResponseEntity<> ("Owner not found", HttpStatus.NOT_FOUND);
		if (!specieRepo.existsById(petNew.getSpecieId()))
			return new ResponseEntity<> ("Specie not found", HttpStatus.NOT_FOUND);
		if (petRepo.existsByName(petNew.getName()))
			return new ResponseEntity<> ("Name already taken", HttpStatus.BAD_REQUEST);
		PetEntity pet = new PetEntity();
		pet.setName(petNew.getName());
		pet.setOwner(userRepo.findById(petNew.getOwnerId()).orElse(null));
		pet.setSpecie(specieRepo.findById(petNew.getSpecieId()).orElse(null));
		return new ResponseEntity<> (dto.sendPet(petRepo.save(pet)), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> disownPet(Integer id) {
		PetEntity pet = petRepo.findById(id).orElse(null);
		if (pet == null)
			return new ResponseEntity<> ("Pet Not Found", HttpStatus.NOT_FOUND);
		pet.setOwner(null);
		return new ResponseEntity<> (dto.sendPet(petRepo.save(pet)), HttpStatus.OK);
	}

}