package com.nnh.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "bill")
public class BillEntity extends BaseEntity{
	@Column(name = "service_charge")
	private Integer serviceCharge;
	
	@Column(name = "department_charge")
	private Integer departmentCharge;
	
	@Column(name = "late_checkout")
	private Integer lateCheckout;
	
	@OneToOne
	@JoinColumn(name = "booking_id")
	private BookingEntity booking;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity userBill;
	
	@ManyToMany
	@JoinTable(name = "bill_payment",
	joinColumns = @JoinColumn(name = "bill_id"),
	inverseJoinColumns = @JoinColumn(name = "payment_id"))
	private List<PaymentEntity> payments = new ArrayList<PaymentEntity>();

	public Integer getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(Integer serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public Integer getDepartmentCharge() {
		return departmentCharge;
	}

	public void setDepartmentCharge(Integer departmentCharge) {
		this.departmentCharge = departmentCharge;
	}

	public Integer getLateCheckout() {
		return lateCheckout;
	}

	public void setLateCheckout(Integer lateCheckout) {
		this.lateCheckout = lateCheckout;
	}

	public BookingEntity getBooking() {
		return booking;
	}

	public void setBooking(BookingEntity booking) {
		this.booking = booking;
	}

	public UserEntity getUserBill() {
		return userBill;
	}

	public void setUserBill(UserEntity userBill) {
		this.userBill = userBill;
	}

	public List<PaymentEntity> getPayments() {
		return payments;
	}

	public void setPayments(List<PaymentEntity> payments) {
		this.payments = payments;
	}
	
	
}
