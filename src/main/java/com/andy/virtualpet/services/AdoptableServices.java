package com.andy.virtualpet.services;

import org.springframework.http.ResponseEntity;

import com.andy.virtualpet.dtos.DtoGetAdoptable;

public interface AdoptableServices {

	ResponseEntity<?> newAdoptable(DtoGetAdoptable adoptableNew);

	ResponseEntity<?> getAllAdoptables();

	ResponseEntity<?> getOneAdoptable(Integer id);

	ResponseEntity<?> editAdoptable(Integer id, DtoGetAdoptable adoptableEdit);

	ResponseEntity<?> deleteAdoptable(Integer id);

	ResponseEntity<?> getPetsOfType(Integer id);

}
