package com.andy.virtualpet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.andy.virtualpet.dtos.DtoGetItem;
import com.andy.virtualpet.services.ItemServices;

@RestController
public class ItemController {
	
	@Autowired
	private ItemServices itemServ;

	//make one potion
	public ResponseEntity<?> makeNewPotion(@RequestBody DtoGetItem potion){
		return itemServ.makeItem(potion, 'p');
	}
	//make one care
	public ResponseEntity<?> makeNewCare(@RequestBody DtoGetItem care){
		return itemServ.makeItem(care, 'c');
	}
	//make one equip
	public ResponseEntity<?> makeNewEquip(@RequestBody DtoGetItem equip){
		return itemServ.makeItem(equip, 'e');
	}
	//get all
	public ResponseEntity<?> getAllItems(){
		return itemServ.getItems('a');
	}
	//get all potion
	public ResponseEntity<?> getAllPotion(){
		return itemServ.getItems('p');
	}
	//get all care
	public ResponseEntity<?> getAllCare(){
		return itemServ.getItems('c');
	}
	//get all equip
	public ResponseEntity<?> getAllEquip(){
		return itemServ.getItems('e');
	}
	
	//get one
	public ResponseEntity<?> getOneItem(@PathVariable Integer id){
		return itemServ.getOneItem(id);
	}
	//delete one
	public ResponseEntity<?> deleteItem(@PathVariable Integer id){
		return itemServ.deleteItem(id);
	}
	//edit one potion
	public ResponseEntity<?> editPotion(@RequestBody DtoGetItem potion, @PathVariable Integer id){
		return itemServ.editItem(id, 'p', potion);
	}
	//edit one care
	public ResponseEntity<?> editCare(@RequestBody DtoGetItem care, @PathVariable Integer id){
		return itemServ.editItem(id, 'c', care);
	}
	//edit one equip
	public ResponseEntity<?> editEquip(@RequestBody DtoGetItem equip, @PathVariable Integer id){
		return itemServ.editItem(id, 'e', equip);
	}
	
	///////////////////////////////////////////
	
	//add one to inventory
	public ResponseEntity<?> addToInventory(Integer user, Integer item){
		return itemServ.addToInv(user, item);
	}
	//drop one from inventory
	public ResponseEntity<?> removeFromInventory(Integer user, Integer item){
		return itemServ.dropFromInv(user, item);
	}
	//use item on pet
	public ResponseEntity<?> useItem(Integer pet, Integer item){
		return itemServ.useItem(pet, item);
	}
	//equip item
	public ResponseEntity<?> equipItem(Integer pet, Integer item){
		return itemServ.equipItem(pet, item);
	}
	//unequip item
	public ResponseEntity<?> unequipItem(Integer pet, Integer item){
		return itemServ.unequipItem(pet, item);
	}
}
