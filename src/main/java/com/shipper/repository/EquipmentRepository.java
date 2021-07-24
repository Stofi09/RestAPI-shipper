package com.shipper.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shipper.domain.Equipment;

public interface EquipmentRepository extends CrudRepository<Equipment, Long> {

	List<Equipment> findAll();
	List<Equipment> findAllByDeliveryListId(Long Id);	
	void deleteById(Long id);
	Equipment findFirstById(Long id);
}
