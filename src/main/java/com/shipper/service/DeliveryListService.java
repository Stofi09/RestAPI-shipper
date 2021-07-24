package com.shipper.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shipper.domain.DeliveryList;
import com.shipper.domain.Equipment;
import com.shipper.repository.DeliveryListRepository;
import com.shipper.repository.EquipmentRepository;

@Service
public class DeliveryListService {

	private EquipmentRepository equipmentRepo;
	private DeliveryListRepository deliveryRepository;
	private DeliveryList deliveryList;
	
	@Autowired
	public void setDeliveryRepository(DeliveryListRepository deliveryRepository) {
		this.deliveryRepository = deliveryRepository;
	}
	
	@Autowired
	public void setEquipmentrepo(EquipmentRepository equipmentRepo) {
		this.equipmentRepo = equipmentRepo;
	}
	
	public List<DeliveryList> getDeliveries() {
		List<DeliveryList> lists = new ArrayList<>();
		lists = deliveryRepository.findAll();
		lists.forEach((l)->l.setQuantitySum(getQuantitySum(l.getId()))); // Checks how many equipment is in the list. 
		return  deliveryRepository.findAll();
	}
	private int getQuantitySum(Long id) {
		return equipmentRepo.findAllByDeliveryListId(id).size();
	}
	public List<DeliveryList> getDeliveriesById(String driver) {
		if(MessageValidator.isNotEmpty(driver)) {
			return  deliveryRepository.findAllByDriver(driver);
		}else {
			return getDeliveries();
		}
	}
	public void deleteList(Long id) {
		if (MessageValidator.isPositiveNumber(id)) {
			deliveryRepository.deleteById(id);
		} else {
			System.err.print("It is not a valid number");
		}
		
	}
	public Long createDeliveryList(String driver, String supplier) {
		if (MessageValidator.areStringsValid(driver, supplier)) {
		DeliveryList delivery = new DeliveryList(driver,supplier,0);
		deliveryRepository.save(delivery);
		return delivery.getId();
		} else {
			return (long)0;
		}
		
	}
	public void updateList(DeliveryList newDelivery) {
		if(MessageValidator.isValidList(newDelivery)) {
			deliveryList = deliveryRepository.findFirstById(newDelivery.getId());
		deliveryList = newDelivery;
		deliveryRepository.save(deliveryList);
		} else {
			System.err.print("Not a valid list.");
		}
		
	}
}
