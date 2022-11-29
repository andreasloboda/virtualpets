package com.andy.virtualpet.dtos;

import java.util.List;

public class DtoReturnUser {
	private Integer id;
	private String username;
	private String role;
	private String nickname;
	private String gender;
	private List<String> pets;
	public DtoReturnUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DtoReturnUser(Integer id, String username, String role, String nickname, String gender, List<String> pets) {
		super();
		this.id = id;
		this.username = username;
		this.role = role;
		this.nickname = nickname;
		this.gender = gender;
		this.pets = pets;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<String> getPets() {
		return pets;
	}
	public void setPets(List<String> pets) {
		this.pets = pets;
	}
	
	
}
