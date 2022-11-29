package com.andy.virtualpet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.andy.virtualpet.dtos.DtoGetItem;
import com.andy.virtualpet.entities.ItemCareEntity;
import com.andy.virtualpet.entities.ItemEquipEntity;
import com.andy.virtualpet.entities.ItemPotionEntity;
import com.andy.virtualpet.repositories.AdoptableRepository;
import com.andy.virtualpet.repositories.ItemCareRepository;
import com.andy.virtualpet.repositories.ItemEquipRepository;
import com.andy.virtualpet.repositories.ItemPotionRepository;
import com.andy.virtualpet.repositories.ItemRepository;

@Service
public class ItemServicesImp implements ItemServices {

	@Autowired
	private ItemRepository itemRepo;
	@Autowired
	private ItemEquipRepository ieRepo;
	@Autowired
	private ItemCareRepository icRepo;
	@Autowired
	private ItemPotionRepository ipRepo;
	@Autowired
	private AdoptableRepository specieRepo;

	@Override
	public ResponseEntity<?> makeItem(DtoGetItem item, char itemType) {
		if (item.getName() != null && !item.getName().isBlank()) {
			if (itemRepo.existsByName(item.getName()))
				return new ResponseEntity<>("Name already taken", HttpStatus.BAD_REQUEST);
			if (itemType == 'e') {
				ItemEquipEntity ei = new ItemEquipEntity();
				ei.setName(item.getName());
				ei.setAttack(item.getAttack());
				if (ei.getAttack() == null)
					ei.setAttack(0);
				ei.setDefense(item.getDefense());
				if (ei.getDefense() == null)
					ei.setDefense(0);
				ei.setHealth(item.getHealth());
				if (ei.getHealth() == null)
					ei.setHealth(0);
				ei.setMagic(item.getMagic());
				if (ei.getMagic() == null)
					ei.setMagic(0);
				ei.setSpeed(item.getSpeed());
				if (ei.getSpeed() == null)
					ei.setSpeed(0);
				return new ResponseEntity<>(ieRepo.save(ei), HttpStatus.OK);
			}
			if (itemType == 'c') {
				ItemCareEntity ci = new ItemCareEntity();
				ci.setName(item.getName());
				ci.setClean(item.getClean());
				if (ci.getClean() == null)
					ci.setClean(0);
				ci.setFun(item.getFun());
				if (ci.getFun() == null)
					ci.setFun(0);
				ci.setHunger(item.getHunger());
				if (ci.getHunger() == null)
					ci.setHunger(0);
				return new ResponseEntity<>(icRepo.save(ci), HttpStatus.OK);
			}
			if (itemType == 'p') {
				ItemPotionEntity pi = new ItemPotionEntity();
				pi.setName(item.getName());
				pi.setHeal(item.getHeal());
				if (pi.getHeal() == null)
					pi.setHeal(0);
				pi.setMana(item.getMana());
				if (pi.getMana() == null)
					pi.setMana(0);
				if (item.getColor() != null) // Colors not implemented yet
					pi.setColor(item.getColor());
				if (item.getSpecie() != null) {
					if (!specieRepo.existsById(item.getSpecie()))
						return new ResponseEntity<>("Specie doesn't exist", HttpStatus.BAD_REQUEST);
					pi.setSpecie(item.getSpecie());
				} else
					pi.setSpecie(null);
				return new ResponseEntity<>(ipRepo.save(pi), HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("Must provide a name", HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<?> editItem(Integer id, char itemType, DtoGetItem item) {
		if (itemRepo.existsById(id)) {
			if (itemType == 'p') {
				ItemPotionEntity ipe = ipRepo.findById(id).orElse(null);
				if (ipe == null)
					return new ResponseEntity<> ("Item of wrong type", HttpStatus.BAD_REQUEST);
				if (item.getName()!=null && !item.getName().equalsIgnoreCase(ipe.getName())) {
					if (itemRepo.existsByName(item.getName()))
						ipe.setName(item.getName());
					else
						return new ResponseEntity<> ("Name Already Taken", HttpStatus.BAD_REQUEST);
				}
				if (item.getSpecie()!=null) {
					if (specieRepo.existsById(item.getSpecie()))
						ipe.setSpecie(item.getSpecie());
					else
						return new ResponseEntity<> ("Specie Not Found", HttpStatus.BAD_REQUEST);
				}
				if (item.getColor()!=null)
					ipe.setColor(item.getColor());
				if (item.getHeal()!=null)
					ipe.setHeal(item.getHeal());
				if (item.getMana()!=null)
					ipe.setMana(item.getMana());
				return new ResponseEntity<> (ipRepo.save(ipe), HttpStatus.OK);
			}
			if (itemType == 'e') {
				ItemEquipEntity iee = ieRepo.findById(id).orElse(null);
				if (iee == null)
					return new ResponseEntity<> ("Item of wrong type", HttpStatus.BAD_REQUEST);
				if (item.getName()!=null && !item.getName().equalsIgnoreCase(iee.getName())) {
					if (itemRepo.existsByName(item.getName()))
						iee.setName(item.getName());
					else
						return new ResponseEntity<> ("Name Already Taken", HttpStatus.BAD_REQUEST);
				}
				if (item.getAttack() != null)
					iee.setAttack(item.getAttack());
				if (item.getDefense() != null)
					iee.setDefense(item.getDefense());
				if (item.getHealth() != null)
					iee.setHealth(item.getHealth());
				if (item.getMagic() != null)
					iee.setMagic(item.getMagic());
				if (item.getSpeed() != null)
					iee.setSpeed(item.getSpeed());
				return new ResponseEntity<> (ieRepo.save(iee), HttpStatus.OK);
			}
			if (itemType == 'c') {
				ItemCareEntity ice = icRepo.findById(id).orElse(null);
				if (ice == null)
					return new ResponseEntity<> ("Item of wrong type", HttpStatus.BAD_REQUEST);
				if (item.getName()!=null && !item.getName().equalsIgnoreCase(ice.getName())) {
					if (itemRepo.existsByName(item.getName()))
						ice.setName(item.getName());
					else
						return new ResponseEntity<> ("Name Already Taken", HttpStatus.BAD_REQUEST);
				}
				if (item.getHunger()!=null)
					ice.setHunger(item.getHunger());
				if (item.getFun()!=null)
					ice.setFun(item.getFun());
				if (item.getClean()!=null)
					ice.setClean(item.getClean());
				return new ResponseEntity<> (icRepo.save(ice), HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("Item Not Found", HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<?> deleteItem(Integer id) {
		if (itemRepo.existsById(id)) {
			itemRepo.deleteById(id);
			return new ResponseEntity<> ("Item successfully deleted", HttpStatus.OK);
		}
		return new ResponseEntity<> ("Item Not Found", HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<?> getItems(char itemType) {
		if (itemType == 'p') {
			List<ItemPotionEntity> items = (List<ItemPotionEntity>) ipRepo.findAll();
			if (items.isEmpty())
				return new ResponseEntity<> ("No Potions Found", HttpStatus.OK);
			return new ResponseEntity<> (items, HttpStatus.OK);
		}
		if (itemType == 'c') {
			List<ItemCareEntity> items = (List<ItemCareEntity>) icRepo.findAll();
			if (items.isEmpty())
				return new ResponseEntity<> ("No Care Items Found", HttpStatus.OK);
			return new ResponseEntity<> (items, HttpStatus.OK);
		}
		if (itemType == 'e') {
			List<ItemEquipEntity> items = (List<ItemEquipEntity>) ieRepo.findAll();
			if (items.isEmpty())
				return new ResponseEntity<> ("No Equipment Found", HttpStatus.OK);
			return new ResponseEntity<> (items, HttpStatus.OK);
		}
		return null;
	}

	@Override
	public ResponseEntity<?> getOneItem(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getInv(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> addToInv(Integer user, Integer item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> dropFromInv(Integer user, Integer item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> useItem(Integer pet, Integer item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> equipItem(Integer pet, Integer item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> unequipItem(Integer pet, Integer item) {
		// TODO Auto-generated method stub
		return null;
	}

}
