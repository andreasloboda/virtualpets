package com.andy.virtualpet.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.andy.virtualpet.entities.PetEntity;

public interface PetRepository extends CrudRepository<PetEntity, Integer>{

	boolean existsByName(String name);

	Optional<PetEntity> findByName(String nn);

}
