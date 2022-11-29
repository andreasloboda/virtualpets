package com.andy.virtualpet.dtos;

public class DtoGetPet {

	String name;
	Integer ownerId;
	Integer specieId;
	
	public DtoGetPet() {
		super();
	}

	public DtoGetPet(String name, Integer ownerId, Integer specieId) {
		super();
		this.name = name;
		this.ownerId = ownerId;
		this.specieId = specieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public Integer getSpecieId() {
		return specieId;
	}

	public void setSpecieId(Integer specieId) {
		this.specieId = specieId;
	}
}
