package com.jobportal.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="payment")
public class Payment {
	@Id
	@Column(name="payment_id")
	private String paymentId;
	
	@Column(name="recruiter_id")
	private String recruiterId;
	
	@Column(name="plan")
	private String plan;
	
	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	@Column(name="amount")
	private float amount;
	
	@Column(name="discount")
	private float discount;
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(String paymentId, String recruiterId, String plan, Date startDate, Date endDate, float amount,
			float discount) {
		super();
		this.paymentId = paymentId;
		this.recruiterId = recruiterId;
		this.plan = plan;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.discount = discount;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getRecruiterId() {
		return recruiterId;
	}

	public void setRecruiterId(String recruiterId) {
		this.recruiterId = recruiterId;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}
}
