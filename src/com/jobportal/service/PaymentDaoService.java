package com.jobportal.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jobportal.dao.JobCategoryDao;
import com.jobportal.dao.JobSeekerDao;
import com.jobportal.dao.PaymentDao;
import com.jobportal.dao.RecruiterDao;
import com.jobportal.entity.Application;
import com.jobportal.entity.JobCategory;
import com.jobportal.entity.JobSeeker;
import com.jobportal.entity.Payment;
import com.jobportal.entity.Recruiter;
import com.jobportal.model.ApplicationModel;
import com.jobportal.model.JobCategoryModel;
import com.jobportal.model.JobSeekerModel;
import com.jobportal.model.PaymentModel;
import com.jobportal.model.RecruiterModel;
import com.jobportal.model.RegisterPaymentForm;
import com.jobportal.util.DateFormat;

@Service
@Repository("PaymentDaoService")
public class PaymentDaoService {
	@Autowired
	private RecruiterDao myRecruiterDao;
	
	@Autowired
	private PaymentDao myPaymentDao;
	
	public void getRecruiterbyId(RecruiterModel model){
		String rid=model.getFrmRecruiterId();
		Recruiter r=this.myRecruiterDao.getRecruiterById(rid);
		model.setRecruiter(r);
	}
	
	public void registerPayment(PaymentModel model){
		Payment p=new Payment();
		String plan=model.getFrmPlan();
		p.setPaymentId(model.getFrmPaymentId());
		p.setRecruiterId(model.getFrmRecruiterId());
		System.out.println("Pyament dao service "+model.getFrmRecruiterId());
		p.setPlan(model.getFrmPlan());
		p.setAmount(Float.parseFloat(model.getFrmAmount()));
		p.setDiscount(Float.parseFloat(model.getFrmDiscount()));
		
		if(plan.equals("monthly")){
			Date startDate=new Date();
			Date endDate=DateFormat.add30Days(startDate);
			p.setStartDate(startDate);
			p.setEndDate(endDate);		
		}else{
			Date startDate=new Date();
			Date endDate=DateFormat.add365Days(startDate);
			p.setStartDate(startDate);
			p.setEndDate(endDate);
			
		}
		
		this.myPaymentDao.savePayment(p);
	}
	
	public void getPaymentByRecruiterId(PaymentModel model){
		String recruitrId=model.getFrmRecruiterId();
		List<Payment> list=this.myPaymentDao.getAllPaymentByRecruiterId(recruitrId);
		model.setPaymentList(list);
	}
	
	public Boolean checkPaymentByRecruiterId(PaymentModel model){
		String recruiterId=model.getFrmRecruiterId();
		Boolean b=false;
		System.out.println("Payment Dao Service Check Payment By Recruiter:"+recruiterId);
		List<Payment> list=this.myPaymentDao.getAllPaymentByRecruiterId(recruiterId);
		Date currentDate=new Date();
			System.out.println("Payment Dao Service Check Payment By Recruiter list not equal null");
			if(list==null){
				System.out.println("Not created payment");
				b=true;
				return b;
			}else{
			for(Payment p : list){
				if(p.getEndDate().compareTo(currentDate) >0){
					System.out.println("Already make payment"+b);
					b=false;
					return b;}
//				}else {
//					System.out.println("Error Testing for Already make payment:"+p.getEndDate());
//					b=true;
//					return b;
//				}
			}
	}
			System.out.println("End date is over ");
			b=true;
			return b;
}
	public void getAllPayments(RegisterPaymentForm model){
		List<Payment> l=this.myPaymentDao.getAllPayment();
		List<Payment> list1=new ArrayList<Payment>();
		List<Recruiter> rlist=new ArrayList<Recruiter>();
		for(Payment p:l){
			String recruiterId=p.getRecruiterId();
			Recruiter recruiter=this.myRecruiterDao.getRecruiterById(recruiterId);	
			rlist.add(recruiter);
			
			list1.add(p);
			}
		model.setRecruiterList(rlist);
		model.setPaymentList(list1);
	}
}
