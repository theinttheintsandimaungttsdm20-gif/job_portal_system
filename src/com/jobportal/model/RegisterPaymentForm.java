package com.jobportal.model;

import java.util.List;

import com.jobportal.entity.Payment;
import com.jobportal.entity.Recruiter;

public class RegisterPaymentForm {
	private RecruiterModel recruiterModel;
	private PaymentModel paymentModel;
	private OrderDetail orderDetail;
	private Recruiter recruiter;
	private List<Recruiter> recruiterList;
	public List<Recruiter> getRecruiterList() {
		return recruiterList;
	}
	public void setRecruiterList(List<Recruiter> recruiterList) {
		this.recruiterList = recruiterList;
	}
	private List<Payment> paymentList;
	
	
	public Recruiter getRecruiter() {
		return recruiter;
	}
	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}
	public List<Payment> getPaymentList() {
		return paymentList;
	}
	public void setPaymentList(List<Payment> paymentList) {
		this.paymentList = paymentList;
	}
	public RecruiterModel getRecruiterModel() {
		return recruiterModel;
	}
	public OrderDetail getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}
	public void setRecruiterModel(RecruiterModel recruiterModel) {
		this.recruiterModel = recruiterModel;
	}
	public PaymentModel getPaymentModel() {
		return paymentModel;
	}
	public void setPaymentModel(PaymentModel paymentModel) {
		this.paymentModel = paymentModel;
	}
}
