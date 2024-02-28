package com.nnh.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity{
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "phone_num")
	private Integer phoneNum;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "salary")
	private Integer salary;
	
	@ManyToMany
	@JoinTable(name = "user_role",
	joinColumns = @JoinColumn(name ="user_id"),
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<RoleEntity> roles = new ArrayList<RoleEntity>();
	
	@OneToMany(mappedBy = "userComment")
	private List<CommentEntity> comments = new ArrayList<CommentEntity>();
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private CityEntity cityUser;
	
	@OneToMany(mappedBy = "userBill")
	private List<BillEntity> bills = new ArrayList<BillEntity>();
	
	@OneToMany(mappedBy = "userBooking")
	private List<BookingEntity> bookings = new ArrayList<BookingEntity>();

	
	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
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

	public Integer getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(Integer phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	public CityEntity getCityUser() {
		return cityUser;
	}

	public void setCityUser(CityEntity cityUser) {
		this.cityUser = cityUser;
	}

	public List<BillEntity> getBills() {
		return bills;
	}

	public void setBills(List<BillEntity> bills) {
		this.bills = bills;
	}

	public List<BookingEntity> getBookings() {
		return bookings;
	}

	public void setBookings(List<BookingEntity> bookings) {
		this.bookings = bookings;
	}
	
	
	
	
}
