package com.dev118.jexample.spring.data.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

/**
 * 车牌号，例：辽B P9999
 * 
 * @author Wen
 *
 */
@Embeddable
public class CarPK implements Serializable {

	private static final long serialVersionUID = 5923137372290138711L;

	@Column(length = 1, nullable = false)
	private String province;

	@Column(length = 1, nullable = false)
	@Pattern(regexp = "[A-Z]{1}")
	private String city;

	@Column(length = 5, nullable = false)
	@Length(min = 5, max = 5)
	private String number;

	public CarPK() {
		super();
	}

	public CarPK(String province, String city, String number) {
		super();
		this.province = province;
		this.city = city;
		this.number = number;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "CarPK [province=" + province + ", city=" + city + ", number=" + number + "]";
	}

}
