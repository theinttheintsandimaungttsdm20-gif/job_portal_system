package com.jobportal.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jobportal.entity.Application;
import com.jobportal.entity.Job;
import com.jobportal.entity.JobCategory;
import com.jobportal.entity.JobSeeker;
import com.jobportal.entity.JobSeekerEducation;
import com.jobportal.entity.JobSeekerWorkExp;
import com.jobportal.entity.Payment;
import com.jobportal.entity.Selection;
import com.jobportal.util.JobSeekerId;

@Repository("PaymentDao")
public class PaymentDao extends AbstractDao<Integer, Payment> {
	
	public void savePayment(Payment payment)
	{
		super.persistVoid(payment);
    }
	public Payment getPaymentById(String id){
		Payment l=super.criteriaQueryGetObjectByName(id, "paymentId");
		return l;
	}
	public List<Payment> getAllPayment(){
		List<Payment> list=super.getAllEntity();
		System.out.println("Payment DAO---------->"+list.size());
		return list;
	}
	
	public List<Payment> getAllPaymentByRecruiterId(String id){
		List<Payment> list=super.criteriaQueryGetObjectsByName(id, "recruiterId");
		return list;

	}
	public void deletePaymentById(Payment p){
		super.delete(p);
	}
}
