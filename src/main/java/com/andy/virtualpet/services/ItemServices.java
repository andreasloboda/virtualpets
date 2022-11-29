package com.andy.virtualpet.services;

import org.springframework.http.ResponseEntity;

import com.andy.virtualpet.dtos.DtoGetItem;

public interface ItemServices {

	ResponseEntity<?> makeItem(DtoGetItem item, char itemType);

	ResponseEntity<?> editItem(Integer id, char itemType, DtoGetItem item);

	ResponseEntity<?> deleteItem(Integer id);

	ResponseEntity<?> getItems(char itemType);

	ResponseEntity<?> getOneItem(Integer id);

	ResponseEntity<?> getInv(Integer id);

	ResponseEntity<?> addToInv(Integer user, Integer item);

	ResponseEntity<?> dropFromInv(Integer user, Integer item);

	ResponseEntity<?> useItem(Integer pet, Integer item);

	ResponseEntity<?> equipItem(Integer pet, Integer item);

	ResponseEntity<?> unequipItem(Integer pet, Integer item);

}
