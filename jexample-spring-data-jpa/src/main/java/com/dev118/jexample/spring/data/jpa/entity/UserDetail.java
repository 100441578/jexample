package com.dev118.jexample.spring.data.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dev118.jexample.spring.data.jpa.entity.type.SexType;

@Entity
@Table(name = "user_detail")
public class UserDetail extends BaseEntity {

	private static final long serialVersionUID = 8631914530193892015L;

	@Column(length = 64, nullable = false)
	private String name;

	@Column(length = 16, nullable = false)
	@Enumerated(EnumType.STRING)
	private SexType sex;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date birthday;

	@OneToOne(mappedBy = "userDetail")
	private User user;

	public UserDetail() {
		super();
	}

	public UserDetail(String name, SexType sex, Date birthday) {
		super();
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SexType getSex() {
		return sex;
	}

	public void setSex(SexType sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserDetail [name=" + name + ", sex=" + sex + ", birthday=" + birthday + "]";
	}

}
