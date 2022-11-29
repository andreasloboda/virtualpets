package com.andy.virtualpet.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.andy.virtualpet.dtos.DtoEditUser;
import com.andy.virtualpet.dtos.DtoGetNewUser;
import com.andy.virtualpet.dtos.DtoReturnUser;
import com.andy.virtualpet.entities.UserEntity;
import com.andy.virtualpet.enums.Gender;
import com.andy.virtualpet.repositories.UserRepository;

@Service
public class UserServicesImp implements UserServices {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private DTOServices dto;

	@Override
	public ResponseEntity<?> makeNewUser(DtoGetNewUser userNew) {
		if ((userNew.getUsername() == null) || (userNew.getPassword() == null) || (userNew.getRole() == null))
			return new ResponseEntity<>("Missing information", HttpStatus.BAD_REQUEST);
		if (userRepo.existsByUsername(userNew.getUsername()))
			return new ResponseEntity<>("Username already taken", HttpStatus.BAD_REQUEST);
		UserEntity user = new UserEntity();
		user.setUsername(userNew.getUsername());
		user.setPassword(userNew.getPassword());
		user.setRole(dto.stringToEnumRole(userNew.getRole()));
		if (userNew.getNickname() != null)
			user.setNickname(userNew.getNickname());
		else
			user.setNickname(userNew.getUsername());
		user.setGender(dto.stringToEnumGender(userNew.getGender()));
		return new ResponseEntity<>(dto.sendUser(userRepo.save(user)), HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<?> getAllUsers() {
		List<UserEntity> userList = (List<UserEntity>) userRepo.findAll();
		if (userList.isEmpty())
			return new ResponseEntity<>("No Users Found", HttpStatus.OK);
		List<DtoReturnUser> response = new ArrayList<>();
		for (UserEntity i : userList)
			response.add(dto.sendUser(i));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getUserByID(Integer id) {
		if (!userRepo.existsById(id))
			return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
		UserEntity user = userRepo.findById(id).orElse(null);
		return new ResponseEntity<>(dto.sendUser(user), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> editUser(Integer id, DtoEditUser userEdit) {
		if (userRepo.existsById(id)) {
			UserEntity user = userRepo.findById(id).orElse(null);
			if (userEdit.getUsername()!=null)
				user.setUsername(userEdit.getUsername());
			if (userEdit.getNickname()!=null)
				user.setNickname(userEdit.getNickname());
			if (userEdit.getGender()!=null)
				user.setGender(dto.stringToEnumGender(userEdit.getGender()));
			if (userEdit.getRole()!=null)
				user.setRole(dto.stringToEnumRole(userEdit.getRole()));
			/*Following two IFs exist due to expansion of entities during coding and can
			 * be deleted at later date */
			if (user.getNickname()==null)
				user.setNickname(user.getUsername());
			if (user.getGender()==null)
				user.setGender(Gender.OTHER);
			return new ResponseEntity<>(dto.sendUser(userRepo.save(user)), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<?> deleteUser(Integer id) {
		if (userRepo.existsById(id)) {
			userRepo.deleteById(id);
			return new ResponseEntity<>("User Deleted", HttpStatus.OK);
		}
		return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<?> getUserByUsername(String un) {
		if (userRepo.existsByUsername(un)) {
			UserEntity user = userRepo.findByUsername(un);
			return new ResponseEntity<>(dto.sendUser(user), HttpStatus.OK);
			}
		return new ResponseEntity<>("No Users Found", HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<?> getPetList(Integer id) {
		if (userRepo.existsById(id)) {
			UserEntity user = userRepo.findById(id).orElse(null);
			return new ResponseEntity<>(dto.formPetList(user.getPets()), HttpStatus.OK);
		}
		return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
	}

}
