package com.onlinevegetable.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class VegetableDTO 
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int vegId;
private String name;
private String type;
private double price;
private int quantity;
public VegetableDTO()
{
}
public VegetableDTO(int vegId, String name, String type, double price, int quantity) {
	this.vegId = vegId;
	this.name = name;
	this.type = type;
	this.price = price;
	this.quantity = quantity;
}
public int getVegId() {
	return vegId;
}
public void setVegId(int vegId) {
	this.vegId = vegId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}

















}
