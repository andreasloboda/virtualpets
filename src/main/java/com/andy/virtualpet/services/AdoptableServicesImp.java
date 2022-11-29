package com.andy.virtualpet.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.andy.virtualpet.dtos.DtoGetAdoptable;
import com.andy.virtualpet.dtos.DtoReturnAdoptable;
import com.andy.virtualpet.entities.AdoptableEntity;
import com.andy.virtualpet.entities.PetEntity;
import com.andy.virtualpet.repositories.AdoptableRepository;

@Service
public class AdoptableServicesImp implements AdoptableServices{
	
	@Autowired
	private DTOServices dto;
	@Autowired
	private AdoptableRepository repo;

	@Override
	public ResponseEntity<?> newAdoptable(DtoGetAdoptable adoptableNew) {
		if ((adoptableNew.getSpecie() == null) || (adoptableNew.getSpecie().isBlank()))
			return new ResponseEntity<> ("Specie name not valid", HttpStatus.BAD_REQUEST);
		if (repo.existsBySpecie(adoptableNew.getSpecie()))
			return new ResponseEntity<> ("Specie already exists", HttpStatus.BAD_REQUEST);
		AdoptableEntity specieNew = new AdoptableEntity();
		specieNew.setSpecie(adoptableNew.getSpecie());
		return new ResponseEntity<> (dto.sendAdoptable(repo.save(specieNew)), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getAllAdoptables() {
		List<AdoptableEntity> adoptList = (List<AdoptableEntity>) repo.findAll();
		if (adoptList.isEmpty())
			return new ResponseEntity<> ("No Adoptables Found", HttpStatus.OK);
		List<DtoReturnAdoptable> response = new ArrayList<>();
		for (AdoptableEntity i : adoptList)
			response.add(dto.sendAdoptable(i));
		return new ResponseEntity<> (response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getOneAdoptable(Integer id) {
		if (repo.existsById(id))
			return new ResponseEntity<> (dto.sendAdoptable(repo.findById(id).orElse(null)), HttpStatus.OK);
		return new ResponseEntity<> ("Adoptable not found", HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<?> editAdoptable(Integer id, DtoGetAdoptable adoptableEdit) {
		if (!repo.existsById(id))
			return new ResponseEntity<> ("Adoptable not found", HttpStatus.NOT_FOUND);
		AdoptableEntity edited = repo.findById(id).orElse(null);
		if (adoptableEdit.getSpecie() != null)
			edited.setSpecie(adoptableEdit.getSpecie());
		return new ResponseEntity<> (dto.sendAdoptable(repo.save(edited)), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteAdoptable(Integer id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return new ResponseEntity<> ("Adoptable deleted", HttpStatus.OK);
		}
		return new ResponseEntity<> ("Adoptable not found", HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<?> getPetsOfType(Integer id) {
		if (repo.existsById(id)) {
			List<PetEntity> petList = repo.findById(id).orElse(null).getPets();
			List<String> response = new ArrayList<>();
			if (!petList.isEmpty()) {
				for (PetEntity i : petList) {
					response.add(i.getName());
				}
			}
			return new ResponseEntity<> (response, HttpStatus.OK);
		}
		return new ResponseEntity<> ("Adoptable not found", HttpStatus.NOT_FOUND);
	}

	
}
