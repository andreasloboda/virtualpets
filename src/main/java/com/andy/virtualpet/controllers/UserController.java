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

import com.andy.virtualpet.dtos.DtoEditUser;
import com.andy.virtualpet.dtos.DtoGetNewUser;
import com.andy.virtualpet.services.ItemServices;
import com.andy.virtualpet.services.UserServices;

@RestController
public class UserController {
	
	@Autowired
	private UserServices userServ;
	@Autowired
	private ItemServices itemServ;
	
	//Make new
	@PostMapping("/users/new")
	public ResponseEntity<?> makeNew(@RequestBody DtoGetNewUser userNew){
		return userServ.makeNewUser(userNew);
	}
	
	//Get all
	@GetMapping("/users/")
	public ResponseEntity<?> getAll() {
		return userServ.getAllUsers();
	}
	
	//Get one
	@GetMapping("/users/id/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id) {
		return userServ.getUserByID(id);
	}
	//Edit one
	@PutMapping("/users/id/{id}")
	public ResponseEntity<?> editOne(@PathVariable Integer id, @RequestBody DtoEditUser userEdit){
		return userServ.editUser(id, userEdit);
	}
	//Delete one
	@DeleteMapping("/users/id/{id}")
	public ResponseEntity<?> deleteOne(@PathVariable Integer id){
		return userServ.deleteUser(id);
	}
	//Get owner's pets
	@GetMapping("/users/pets/{id}")
	public ResponseEntity<?> getUsersPets(@PathVariable Integer id) {
		return userServ.getPetList(id);
	}
	//Find Player by username
	@GetMapping("/users/name/{un}")
	public ResponseEntity<?> getUserByName(@PathVariable String un) {
		return userServ.getUserByUsername(un);
	}
	
	//Get Full Inventory
	@GetMapping("/users/inventory/{id}")
	public ResponseEntity<?> getUsersInventory(@PathVariable Integer id) {
		return itemServ.getInv(id);
	}
}
