package com.dev118.jexample.basic.copy;

public class BeanOfCopy {

	private Integer id;

	private String code;

	public BeanOfCopy() {
		super();
	}

	public BeanOfCopy(Integer id, String code) {
		super();
		this.id = id;
		this.code = code;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "BeanOfCopy [id=" + id + ", code=" + code + "]";
	}

}
