package com.andy.virtualpet.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import com.andy.virtualpet.enums.ItemType;

@Entity
public class ItemEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Version
	private Integer version;
	private String name;
	private ItemType type;
	
	public ItemEntity() {
		super();
	}
	public ItemEntity(Integer id, Integer version, String name, ItemType type) {
		super();
		this.id = id;
		this.version = version;
		this.name = name;
		this.type = type;
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
	public ItemType getType() {
		return type;
	}
	public void setType(ItemType type) {
		this.type = type;
	}
}
