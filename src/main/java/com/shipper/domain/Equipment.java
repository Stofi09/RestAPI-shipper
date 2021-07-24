package com.shipper.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;




@Entity
public class Equipment {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private int quantity;
	
	@ManyToOne
	private DeliveryList deliveryList;
	
	private Equipment() {};

	public Equipment(String name,int quantity,DeliveryList deliveryList) {
		this.name = name;
		this.quantity = quantity;
		this.deliveryList = deliveryList;
	};
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public DeliveryList getDelivery() {
		return deliveryList;
	}
	public void setDelivery(DeliveryList deliveryList) {
		this.deliveryList = deliveryList;
	}
	@Override
	public String toString() {
		return "Equipment [id=" + id + ", name=" + name + ", quantity=" + quantity + ", deliveryList=" + deliveryList
				+ "]";
	}
	



}
