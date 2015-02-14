package com.dev118.jexample.spring.data.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.dev118.jexample.spring.data.jpa.entity.type.UserCategoryType;
import com.dev118.jexample.spring.data.jpa.entity.type.UserStateType;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

	private static final long serialVersionUID = 2589783377596653965L;

	@Column(length = 64, nullable = false, unique = true)
	private String username;

	@Column(length = 32, nullable = false)
	private String password;

	/**
	 * 用户分类
	 */
	@Column(name = "user_category_type", length = 16, nullable = false)
	@Enumerated(EnumType.STRING)
	private UserCategoryType userCategoryType;

	/**
	 * 用户状态
	 */
	@Column(name = "user_state_type", length = 1, nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private UserStateType userStateType;

	/**
	 * 一对一：用户详细信息
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_detail")
	private UserDetail userDetail;

	/**
	 * 一对多：一个用户多辆车
	 */
	@OneToMany(mappedBy = "user")
	private List<Car> carList;

	/**
	 * 多对多：一个用户有多个角色
	 */
	@ManyToMany
	@JoinTable(name = "rel_user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roleList;

	public User() {
		super();
	}

	public User(String username, String password, UserCategoryType userCategoryType, UserStateType userStateType) {
		super();
		this.username = username;
		this.password = password;
		this.userCategoryType = userCategoryType;
		this.userStateType = userStateType;
	}

	public User(String username, String password, UserCategoryType userCategoryType, UserStateType userStateType, UserDetail userDetail) {
		super();
		this.username = username;
		this.password = password;
		this.userCategoryType = userCategoryType;
		this.userStateType = userStateType;
		this.userDetail = userDetail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserCategoryType getUserCategoryType() {
		return userCategoryType;
	}

	public void setUserCategoryType(UserCategoryType userCategoryType) {
		this.userCategoryType = userCategoryType;
	}

	public UserStateType getUserStateType() {
		return userStateType;
	}

	public void setUserStateType(UserStateType userStateType) {
		this.userStateType = userStateType;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public List<Car> getCarList() {
		return carList;
	}

	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", userCategoryType=" + userCategoryType + ", userStateType=" + userStateType
				+ ", userDetail=" + userDetail + "]";
	}

}
