package com.andy.virtualpet.services;

import java.util.List;

import com.andy.virtualpet.dtos.DtoReturnAdoptable;
import com.andy.virtualpet.dtos.DtoReturnUser;
import com.andy.virtualpet.dtos.DtoReturnPet;
import com.andy.virtualpet.entities.AdoptableEntity;
import com.andy.virtualpet.entities.PetEntity;
import com.andy.virtualpet.entities.UserEntity;
import com.andy.virtualpet.enums.Gender;
import com.andy.virtualpet.enums.UserRole;

public interface DTOServices {

	UserRole stringToEnumRole(String role);

	DtoReturnUser sendUser(UserEntity user);

	Gender stringToEnumGender(String gender);

	List<String> formPetList(List<PetEntity> pets);

	DtoReturnAdoptable sendAdoptable(AdoptableEntity adoptable);

	DtoReturnPet sendPet(PetEntity pet);

}
