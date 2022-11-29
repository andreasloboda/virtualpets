package com.andy.virtualpet.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class AdoptableEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Version
	private Integer version;
	private String specie;
	
	@OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "specie")
	private List<PetEntity> pets;

	public AdoptableEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdoptableEntity(Integer id, Integer version, String specie, List<PetEntity> pets) {
		super();
		this.id = id;
		this.version = version;
		this.specie = specie;
		this.pets = pets;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getSpecie() {
		return specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}

	public List<PetEntity> getPets() {
		return pets;
	}

	public void setPets(List<PetEntity> pets) {
		this.pets = pets;
	}
	
}
