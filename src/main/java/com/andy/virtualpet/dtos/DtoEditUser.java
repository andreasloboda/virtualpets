package com.andy.virtualpet.dtos;

public class DtoEditUser {

	private String username;
	private String role;
	private String nickname;
	private String gender;
	
	public DtoEditUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DtoEditUser(String username, String role, String nickname, String gender) {
		super();
		this.username = username;
		this.role = role;
		this.nickname = nickname;
		this.gender = gender;
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
	
}
