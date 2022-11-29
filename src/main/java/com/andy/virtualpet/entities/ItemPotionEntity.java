package com.andy.virtualpet.entities;

import javax.persistence.Entity;

import com.andy.virtualpet.enums.ItemType;

@Entity
public class ItemPotionEntity extends ItemEntity{

	private Integer heal;
	private Integer mana;
	private Integer specie;
	private Integer color;

	public ItemPotionEntity() {
		super();
	}
	public ItemPotionEntity(Integer id, Integer version, String name, ItemType type, Integer heal, Integer mana, Integer specie, Integer color) {
		super(id, version, name, type);
		this.heal = heal;
		this.mana = mana;
		this.specie = specie;
		this.color = color;
	}
	public Integer getHeal() {
		return heal;
	}
	public void setHeal(Integer heal) {
		this.heal = heal;
	}
	public Integer getMana() {
		return mana;
	}
	public void setMana(Integer mana) {
		this.mana = mana;
	}
	public Integer getSpecie() {
		return specie;
	}
	public void setSpecie(Integer specie) {
		this.specie = specie;
	}
	public Integer getColor() {
		return color;
	}
	public void setColor(Integer color) {
		this.color = color;
	}
}
