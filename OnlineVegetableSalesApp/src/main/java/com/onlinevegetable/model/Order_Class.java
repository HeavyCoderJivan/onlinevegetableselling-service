package com.onlinevegetable.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
@Entity
public class Order_Class
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int orID;
private String vegetable;
private double totalAmount;
private int quantity;
private int  customerId;
public Order_Class()
{}
public Order_Class(int orID, String vegetable, double totalAmount, int quantity, int customerId) {
	super();
	this.orID = orID;
	this.vegetable = vegetable;
	this.totalAmount = totalAmount;
	this.quantity = quantity;
	this.customerId = customerId;
}
public int getOrID() {
	return orID;
}
public void setOrID(int orID) {
	this.orID = orID;
}
public String getVegetable() {
	return vegetable;
}
public void setVegetable(String vegetable) {
	this.vegetable = vegetable;
}
public double getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(double totalAmount) {
	this.totalAmount = totalAmount;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}



















}
