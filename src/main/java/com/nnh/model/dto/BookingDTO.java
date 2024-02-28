package com.nnh.model.dto;

import java.util.Date;

import com.nnh.model.entity.UserEntity;

public class BookingDTO extends AbstractDTO<BookingDTO>{
	private Date checkinDate;
	private Date checkoutDate;
	private Date bookingDate;
	private Integer childAmount;
	private Integer adultAmount;
	private UserEntity user;
	private Long departmentId;
	private String departmentName;
	
	
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public Date getCheckinDate() {
		return checkinDate;
	}
	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}
	public Date getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Integer getChildAmount() {
		return childAmount;
	}
	public void setChildAmount(Integer childAmount) {
		this.childAmount = childAmount;
	}
	public Integer getAdultAmount() {
		return adultAmount;
	}
	public void setAdultAmount(Integer adultAmount) {
		this.adultAmount = adultAmount;
	}
	
	
}
