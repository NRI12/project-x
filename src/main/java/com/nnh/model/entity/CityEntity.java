package com.nnh.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class CityEntity extends BaseEntity {
	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "cityDepartment")
	private List<DepartmentEntity> hotels = new ArrayList<DepartmentEntity>();
	
	@OneToMany(mappedBy = "cityUser")
	private List<UserEntity> users = new ArrayList<UserEntity>();
	
	@ManyToOne
	@JoinColumn(name = "country_id")
	private CountryEntity country;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DepartmentEntity> getHotels() {
		return hotels;
	}

	public void setHotels(List<DepartmentEntity> hotels) {
		this.hotels = hotels;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public CountryEntity getCountry() {
		return country;
	}

	public void setCountry(CountryEntity country) {
		this.country = country;
	}
	
	
}
