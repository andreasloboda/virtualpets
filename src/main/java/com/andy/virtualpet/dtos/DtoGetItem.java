package com.andy.virtualpet.dtos;

public class DtoGetItem {
	
	private String name;
	
	private Integer attack;
	private Integer defense;
	private Integer health;
	private Integer magic;
	private Integer speed;
	private Integer hunger;
	private Integer fun;
	private Integer clean;
	private Integer heal;
	private Integer mana;
	private Integer specie;
	private Integer color;
	public DtoGetItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DtoGetItem(String name, Integer attack, Integer defense, Integer health, Integer magic, Integer speed,
			Integer hunger, Integer fun, Integer clean, Integer heal, Integer mana, Integer specie, Integer color) {
		super();
		this.name = name;
		this.attack = attack;
		this.defense = defense;
		this.health = health;
		this.magic = magic;
		this.speed = speed;
		this.hunger = hunger;
		this.fun = fun;
		this.clean = clean;
		this.heal = heal;
		this.mana = mana;
		this.specie = specie;
		this.color = color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
