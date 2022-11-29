package com.andy.virtualpet.services;

import org.springframework.http.ResponseEntity;

import com.andy.virtualpet.dtos.DtoEditUser;
import com.andy.virtualpet.dtos.DtoGetNewUser;

public interface UserServices {

	ResponseEntity<?> makeNewUser(DtoGetNewUser userNew);

	ResponseEntity<?> getAllUsers();

	ResponseEntity<?> getUserByID(Integer id);

	ResponseEntity<?> editUser(Integer id, DtoEditUser userEdit);

	ResponseEntity<?> deleteUser(Integer id);

	ResponseEntity<?> getUserByUsername(String un);

	ResponseEntity<?> getPetList(Integer id);
}
