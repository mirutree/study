package com.example.spring01.model.dto;

public class ProductDto {
	
	private String name;
	private double price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public ProductDto(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
}
