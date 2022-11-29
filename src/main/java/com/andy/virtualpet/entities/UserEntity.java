package com.andy.virtualpet.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.andy.virtualpet.enums.Gender;
import com.andy.virtualpet.enums.UserRole;

@Entity
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Version
	private Integer version;
	private String username;
	private UserRole role;
	private String password;
	private String nickname;
	private Gender gender;
	
	@OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "owner")
	private List<PetEntity> pets;
	
	@ElementCollection
	private List<Integer> inventory;

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(Integer id, Integer version, String username, UserRole role, String password, String nickname,
			Gender gender, List<PetEntity> pets, List<Integer> inventory) {
		super();
		this.id = id;
		this.version = version;
		this.username = username;
		this.role = role;
		this.password = password;
		this.nickname = nickname;
		this.gender = gender;
		this.pets = pets;
		this.inventory = inventory;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public List<PetEntity> getPets() {
		return pets;
	}

	public void setPets(List<PetEntity> pets) {
		this.pets = pets;
	}

	public List<Integer> getInventory() {
		return inventory;
	}

	public void setInventory(List<Integer> inventory) {
		this.inventory = inventory;
	}

	
	
}
