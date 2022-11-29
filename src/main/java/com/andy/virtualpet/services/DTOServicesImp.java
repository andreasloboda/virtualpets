package com.andy.virtualpet.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.andy.virtualpet.dtos.DtoReturnAdoptable;
import com.andy.virtualpet.dtos.DtoReturnPet;
import com.andy.virtualpet.dtos.DtoReturnUser;
import com.andy.virtualpet.entities.AdoptableEntity;
import com.andy.virtualpet.entities.PetEntity;
import com.andy.virtualpet.entities.UserEntity;
import com.andy.virtualpet.enums.Gender;
import com.andy.virtualpet.enums.UserRole;

@Service
public class DTOServicesImp implements DTOServices {

	@Override
	public UserRole stringToEnumRole(String role) {
		if (role.toLowerCase().contains("admin"))
			return UserRole.USER_ADMIN;
		if (role.toLowerCase().contains("mod"))
			return UserRole.USER_MOD;
		return UserRole.USER_PLAYER;
	}

	public String enumToStringRole(UserRole role) {
		if (role.equals(UserRole.USER_ADMIN))
			return "admin";
		if (role.equals(UserRole.USER_MOD))
			return "mod";
		return "player";
	}

	@Override
	public DtoReturnUser sendUser(UserEntity user) {
		DtoReturnUser dto = new DtoReturnUser();
		dto.setId(user.getId());
		dto.setRole(enumToStringRole(user.getRole()));
		dto.setUsername(user.getUsername());
		dto.setNickname(user.getNickname());
		dto.setGender(enumToStringGender(user.getGender()));
		dto.setPets(formPetList(user.getPets()));
		return dto;
	}

	@Override
	public List<String> formPetList(List<PetEntity> pets) {
		List<String> petList = new ArrayList<>();
		if (pets != null) {
			for (PetEntity i : pets) {
				petList.add(i.getName());
			}
		}
		return petList;
	}

	private String enumToStringGender(Gender gender) {
		if (gender != null) {
			if (gender.equals(Gender.MALE))
				return "male";
			if (gender.equals(Gender.FEMALE))
				return "female";
		}
		return "other";
	}

	@Override
	public Gender stringToEnumGender(String gender) {
		if (gender != null) {
			if (gender.equalsIgnoreCase("male"))
				return Gender.MALE;
			if (gender.equalsIgnoreCase("female"))
				return Gender.FEMALE;
		}
		return Gender.OTHER;
	}

	//SAVE is name of variable, because I'm Laaaazeeey
	@Override
	public DtoReturnAdoptable sendAdoptable(AdoptableEntity adoptable) {
		DtoReturnAdoptable response = new DtoReturnAdoptable();
		response.setId(adoptable.getId());
		response.setSpecie(adoptable.getSpecie());
		return response;
	}

	@Override
	public DtoReturnPet sendPet(PetEntity pet) {
		DtoReturnPet response = new DtoReturnPet();
		response.setId(pet.getId());
		response.setName(pet.getName());
		if (pet.getOwner()!=null) {
			response.setOwnerId(pet.getOwner().getId());
			response.setOwnerName(pet.getOwner().getUsername());
		}
		else {
			response.setOwnerId(null);
			response.setOwnerName(null);
		}
		response.setSpecieId(pet.getSpecie().getId());
		response.setSpecieName(pet.getSpecie().getSpecie());
		return response;
	}

}
