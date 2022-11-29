package com.andy.virtualpet.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class PetEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Version
	private Integer version;
	private String name;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private UserEntity owner;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private AdoptableEntity specie;
	
	public PetEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PetEntity(Integer id, Integer version, String name, UserEntity owner, AdoptableEntity specie) {
		super();
		this.id = id;
		this.version = version;
		this.name = name;
		this.owner = owner;
		this.specie = specie;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UserEntity getOwner() {
		return owner;
	}
	public void setOwner(UserEntity owner) {
		this.owner = owner;
	}
	public AdoptableEntity getSpecie() {
		return specie;
	}
	public void setSpecie(AdoptableEntity specie) {
		this.specie = specie;
	}
	
}
