package com.jobportal.model;

import java.util.List;

import com.jobportal.entity.Payment;

public class PaymentModel {
	private String frmPaymentId;
	private String frmRecruiterId;
	private String frmPlan;
	private String frmStartDate;
	private String frmEndDate;
	private String frmAmount;
	private String frmDiscount;
	private Payment payment;
	private List<Payment> paymentList;
	public List<Payment> getPaymentList() {
		return paymentList;
	}
	public void setPaymentList(List<Payment> paymentList) {
		this.paymentList = paymentList;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public String getFrmPaymentId() {
		return frmPaymentId;
	}
	public void setFrmPaymentId(String frmPaymentId) {
		this.frmPaymentId = frmPaymentId;
	}
	public String getFrmRecruiterId() {
		return frmRecruiterId;
	}
	public void setFrmRecruiterId(String frmRecruiterId) {
		this.frmRecruiterId = frmRecruiterId;
	}
	public String getFrmPlan() {
		return frmPlan;
	}
	public void setFrmPlan(String frmPlan) {
		this.frmPlan = frmPlan;
	}
	public String getFrmStartDate() {
		return frmStartDate;
	}
	public void setFrmStartDate(String frmStartDate) {
		this.frmStartDate = frmStartDate;
	}
	public String getFrmEndDate() {
		return frmEndDate;
	}
	public void setFrmEndDate(String frmEndDate) {
		this.frmEndDate = frmEndDate;
	}
	public String getFrmAmount() {
		return frmAmount;
	}
	public void setFrmAmount(String frmAmount) {
		this.frmAmount = frmAmount;
	}
	public String getFrmDiscount() {
		return frmDiscount;
	}
	public void setFrmDiscount(String frmDiscount) {
		this.frmDiscount = frmDiscount;
	}
}
