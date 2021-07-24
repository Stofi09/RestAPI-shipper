package com.shipper.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.shipper.domain.DeliveryList;

public interface DeliveryListRepository extends CrudRepository<DeliveryList, Long> {

	List<DeliveryList> findAll();
	List<DeliveryList> findAllByDriver(String driver);
	void deleteById(Long id);
	DeliveryList findFirstById(Long id);
	
}
