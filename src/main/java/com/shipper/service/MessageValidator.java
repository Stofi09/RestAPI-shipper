package com.shipper.service;

import com.shipper.domain.DeliveryList;
import com.shipper.responses.Message;

public class MessageValidator {

	
	private MessageValidator () {}
	
	public static boolean isNotEmpty(String string) {
		return !string.isEmpty();
	}
	
	public static boolean isValidList(DeliveryList list) {
		return (!list.getDriver().isEmpty() && !list.getSupplier().isEmpty() && list.getId() >= 0);
	}
	
	public static boolean isPositiveNumber(Long num) {
		return num > 0;
	}
	
	public static boolean isValidEquipment(String name, int quantity,Long id) {
		return (!name.isEmpty() && quantity >= 0 && id != null);
	}
	
	public static boolean areStringsValid(String s1, String s2) {
		return (!s1.isEmpty() && !s2.isEmpty());
	}
}
