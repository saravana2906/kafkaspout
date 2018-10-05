package com.bean;

import java.io.Serializable;

public class Order implements Serializable {

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", brand=" + brand + ", payment=" + payment + "]";
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	String orderId;
	String brand;
	String payment;
	
	
}