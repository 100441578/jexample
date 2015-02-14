package com.dev118.jexample.spring.data.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car implements Serializable {

	private static final long serialVersionUID = 7189421643445298535L;

	@EmbeddedId
	private CarPK carPK;

	// 颜色
	@Column(length = 32, nullable = false)
	private String color;

	// 品牌
	@Column(length = 64, nullable = false)
	private String brand;

	// 名称
	@Column(length = 64, nullable = false)
	private String fullName;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Car() {
		super();
	}

	public Car(CarPK carPK, String color, String brand, String fullName) {
		this.carPK = carPK;
		this.color = color;
		this.brand = brand;
		this.fullName = fullName;
	}

	public CarPK getCarPK() {
		return carPK;
	}

	public void setCarPK(CarPK carPK) {
		this.carPK = carPK;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "Car [carPK=" + carPK + ", color=" + color + ", brand=" + brand + ", fullName=" + fullName + "]";
	}

}
