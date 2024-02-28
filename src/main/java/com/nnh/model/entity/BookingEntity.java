package com.nnh.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class BookingEntity extends BaseEntity{
	@Column(name = "checkin_date")
	private Date checkinDate;
	
	@Column(name = "checkout_date")
	private Date checkoutDate;
	
	@Column(name = "booking_date")
	private Date bookingDate;
	
	@Column(name = "child_amount")
	private Integer childAmount;
	
	@Column(name = "adult_amount")
	private Integer adultAmount;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity userBooking;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private DepartmentEntity department;
	
	@OneToOne(mappedBy = "booking")
	private BillEntity bill;

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

	public UserEntity getUserBooking() {
		return userBooking;
	}

	public void setUserBooking(UserEntity userBooking) {
		this.userBooking = userBooking;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	public BillEntity getBill() {
		return bill;
	}

	public void setBill(BillEntity bill) {
		this.bill = bill;
	}
	
	

}