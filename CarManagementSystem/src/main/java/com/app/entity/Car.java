package com.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Min(value = 0, message = "Price Should Be Greater Than 0")
	private double price;

	@Min(value = 1900, message = "Cars After The Years 1900")
	private int year;

	@NotBlank(message = "Enter The Car Name")
	private String name;

	@NotBlank(message = "Enter The Model Of Car")
	private String model;

	@NotBlank(message = "Enter The Color Of Car")
	private String color;

	@NotBlank(message = "Enter The FuelType Of Car")
	private String fuelType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public Car(long id, @Min(value = 0, message = "Price Should Be Greater Than 0") double price,
			@Min(value = 1900, message = "Cars After The Years 1900") int year,
			@NotBlank(message = "Enter The Car Name") String name,
			@NotBlank(message = "Enter The Model Of Car") String model,
			@NotBlank(message = "Enter The Color Of Car") String color,
			@NotBlank(message = "Enter The FuelType Of Car") String fuelType) {
		super();
		this.id = id;
		this.price = price;
		this.year = year;
		this.name = name;
		this.model = model;
		this.color = color;
		this.fuelType = fuelType;
	}

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", price=" + price + ", year=" + year + ", name=" + name + ", model=" + model
				+ ", color=" + color + ", fuelType=" + fuelType + "]";
	}

}
