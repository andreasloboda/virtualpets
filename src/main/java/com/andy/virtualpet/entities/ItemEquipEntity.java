package com.andy.virtualpet.entities;

import javax.persistence.Entity;

import com.andy.virtualpet.enums.ItemType;

@Entity
public class ItemEquipEntity extends ItemEntity{

	private Integer attack;
	private Integer defense;
	private Integer health;
	private Integer magic;
	private Integer speed;
	
	public ItemEquipEntity() {
		super();
	}
	
	public ItemEquipEntity(Integer id, Integer version, String name, ItemType type,Integer attack, Integer defense, Integer health,
			Integer magic, Integer speed) {
		super(id, version, name, type);
		this.attack = attack;
		this.defense = defense;
		this.health = health;
		this.magic = magic;
		this.speed = speed;
	}
	public Integer getAttack() {
		return attack;
	}
	public void setAttack(Integer attack) {
		this.attack = attack;
	}
	public Integer getDefense() {
		return defense;
	}
	public void setDefense(Integer defense) {
		this.defense = defense;
	}
	public Integer getHealth() {
		return health;
	}
	public void setHealth(Integer health) {
		this.health = health;
	}
	public Integer getMagic() {
		return magic;
	}
	public void setMagic(Integer magic) {
		this.magic = magic;
	}
	public Integer getSpeed() {
		return speed;
	}
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
}
