package com.andy.virtualpet.dtos;

public class DtoReturnPet {

	private Integer id;
	private String name;
	private Integer ownerId;
	private String ownerName;
	private Integer specieId;
	private String specieName;
	
	public DtoReturnPet() {
		super();
	}

	public DtoReturnPet(Integer id, String name, Integer ownerId, String ownerName, Integer specieId, String specieName) {
		super();
		this.id = id;
		this.name = name;
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.specieId = specieId;
		this.specieName = specieName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public Integer getSpecieId() {
		return specieId;
	}

	public void setSpecieId(Integer specieId) {
		this.specieId = specieId;
	}

	public String getSpecieName() {
		return specieName;
	}

	public void setSpecieName(String specieName) {
		this.specieName = specieName;
	}
	
	
}
