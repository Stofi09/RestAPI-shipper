package com.shipper.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;




@Entity
public class DeliveryList {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String driver;
	private String supplier;
	/*If the Integer's name is quantitySum I got a syntax error exception.*/
	private Integer quantitysum;
	@JsonBackReference
	@OneToMany(mappedBy = "deliveryList")
	private List<Equipment> equipments;
	

	
	private DeliveryList() {}
	
	public DeliveryList(String driver, String supplier, Integer sum) {
		this.driver = driver;
		this.supplier = supplier;
		this.quantitysum = sum;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getDriver() {
		return driver;
	}


	public void setDriver(String driver) {
		this.driver = driver;
	}


	public String getSupplier() {
		return supplier;
	}


	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}


	public List<Equipment> getEquipments() {
		return equipments;
	}


	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}

	
	

	public Integer getQuantitySum() {
		return quantitysum;
	}

	public void setQuantitySum(Integer quantitySum) {
		this.quantitysum = quantitySum;
	}

	@Override
	public String toString() {
		return "DeliveryList [id=" + id + ", driver=" + driver + ", supplier=" + supplier + ", equipments=" + equipments
				+ ", quantitySum=" + quantitysum + "]";
	}




	
}
