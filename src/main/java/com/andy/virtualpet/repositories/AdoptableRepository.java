package com.andy.virtualpet.repositories;

import org.springframework.data.repository.CrudRepository;

import com.andy.virtualpet.entities.AdoptableEntity;

public interface AdoptableRepository extends CrudRepository<AdoptableEntity, Integer>{

	boolean existsBySpecie(String specie);

}
