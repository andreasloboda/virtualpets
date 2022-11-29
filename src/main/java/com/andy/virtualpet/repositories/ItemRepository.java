package com.andy.virtualpet.repositories;

import org.springframework.data.repository.CrudRepository;

import com.andy.virtualpet.entities.ItemEntity;

public interface ItemRepository extends CrudRepository<ItemEntity, Integer> {

	boolean existsByName(String name);

}
