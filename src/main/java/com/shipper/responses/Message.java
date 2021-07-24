package com.shipper.responses;


public class Message {

	private String name;
	private int quantity;
	private Long id;
	private Long deliveryListId;
	
	public Message() {}
	public Message(String name, int quantity, Long id, Long deliveryListId) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.id = id;
		this.deliveryListId = deliveryListId;
	}
	public String getName() {
		return name;
	}
	public int getQuantity() {
		return quantity;
	}
	public Long getId() {
		return id;
	}
	
	public Long getDeliveryListId() {
		return deliveryListId;
	}
	@Override
	public String toString() {
		return "Message [name=" + name + ", quantity=" + quantity + ", id=" + id + ", deliveryListId=" + deliveryListId
				+ "]";
	}
	
	
}
