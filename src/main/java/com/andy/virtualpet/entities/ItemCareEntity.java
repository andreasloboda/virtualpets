package com.andy.virtualpet.entities;

import javax.persistence.Entity;

import com.andy.virtualpet.enums.ItemType;

@Entity
public class ItemCareEntity extends ItemEntity{
//Food, toys and hygiene items
	private Integer hunger;
	private Integer fun;
	private Integer clean;
	public ItemCareEntity() {
		super();
	}
	public ItemCareEntity(Integer id, Integer version, String name, ItemType type, Integer hunger, Integer fun, Integer clean) {
		super(id, version, name, type);
		this.hunger = hunger;
		this.fun = fun;
		this.clean = clean;
	}
	public Integer getHunger() {
		return hunger;
	}
	public void setHunger(Integer hunger) {
		this.hunger = hunger;
	}
	public Integer getFun() {
		return fun;
	}
	public void setFun(Integer fun) {
		this.fun = fun;
	}
	public Integer getClean() {
		return clean;
	}
	public void setClean(Integer clean) {
		this.clean = clean;
	}
}
