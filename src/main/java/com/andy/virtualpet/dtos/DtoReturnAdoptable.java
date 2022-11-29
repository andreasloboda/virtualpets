package com.andy.virtualpet.dtos;

public class DtoReturnAdoptable {

	String specie;
	Integer id;

	public DtoReturnAdoptable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DtoReturnAdoptable(String specie, Integer id) {
		super();
		this.specie = specie;
		this.id = id;
	}

	public String getSpecie() {
		return specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
