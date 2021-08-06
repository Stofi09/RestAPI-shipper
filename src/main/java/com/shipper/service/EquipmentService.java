package com.shipper.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shipper.domain.DeliveryList;
import com.shipper.domain.Equipment;
import com.shipper.repository.DeliveryListRepository;
import com.shipper.repository.EquipmentRepository;
import com.shipper.responses.Message;

@Service
public class EquipmentService {

	private EquipmentRepository equipmentRepo;
	private DeliveryListRepository deliveryRepository;
	private DeliveryList deliveryList;
	private Equipment equipment;
	
	@Autowired
	public void setEquipmentrepo(EquipmentRepository equipmentRepo) {
		this.equipmentRepo = equipmentRepo;
	}
	
	@Autowired
	public void setDeliveryRepository(DeliveryListRepository deliveryRepository) {
		this.deliveryRepository = deliveryRepository;
	}

	public void deleteEquipment(Long id) {
		if (MessageValidator.isPositiveNumber(id)) {
			equipmentRepo.deleteById(id);
		}
		else {
			System.err.print(id + " is not a positive number");
		}
	}

	public Long createEquipment(String equipmentName, int quantity, Long id) {
		if (MessageValidator.isValidEquipment(equipmentName, quantity, id)) {
			deliveryList = deliveryRepository.findFirstById(id);
		Equipment eq = new Equipment(equipmentName,quantity,deliveryList);
		equipmentRepo.save(eq);
		return eq.getId();
		} else {
			System.err.print("Message is not valid!");
			return (long) 0;
		}
		
	}
	public List<Equipment> getEquipments(Long id) {
		if (MessageValidator.isPositiveNumber(id)) {
		return  equipmentRepo.findAllByDeliveryListId(id);
		}else {
			System.err.print(id + " is not a positive number");
			return equipmentRepo.findAll();
		}
	}
	
	public void createDeliveryList(String name, String eq) {
		if (MessageValidator.areStringsValid(name, eq)) {
				DeliveryList delivery = new DeliveryList(name,"Halux",0,false);
		deliveryRepository.save(delivery);	
		Equipment equipment = new Equipment(eq, 6,delivery);
		equipmentRepo.save(equipment);
		} else {
			System.err.print("Message is not valid!");
		}
	
	}
	
	public void updateList(Message message) {
		if (MessageValidator.isValidEquipment(message.getName(),message.getQuantity(), message.getId())) {
		equipment = equipmentRepo.findFirstById(message.getId());
		equipment.setName(message.getName());
		equipment.setQuantity(message.getQuantity());
		equipmentRepo.save(equipment);
		} else {
			System.err.print("Message is not valid!");
		}
	
	}
	
//	@PostConstruct
//	private void init() {
//		DeliveryList delivery = new DeliveryList("Bela","Halux");
//		deliveryRepository.save(delivery);
//		
//		Equipment equipment = new Equipment("Kalapacs", 6,delivery);
//		equipmentRepo.save(equipment);
//	}
	
}
