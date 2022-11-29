package com.andy.virtualpet.repositories;

import org.springframework.data.repository.CrudRepository;

import com.andy.virtualpet.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer>{

	boolean existsByUsername(String username);

	UserEntity findByUsername(String un);

}
