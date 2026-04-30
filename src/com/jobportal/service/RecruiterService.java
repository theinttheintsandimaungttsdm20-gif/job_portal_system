package com.jobportal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jobportal.dao.ApplicationDao;
import com.jobportal.dao.JobCategoryDao;
import com.jobportal.dao.JobDao;
import com.jobportal.dao.JobSeekerDao;
import com.jobportal.dao.LoginDao;
import com.jobportal.dao.PaymentDao;
import com.jobportal.dao.RecruiterDao;
import com.jobportal.entity.Application;
import com.jobportal.entity.Job;
import com.jobportal.entity.JobCategory;
import com.jobportal.entity.JobSeeker;
import com.jobportal.entity.JobSeekerEducation;
import com.jobportal.entity.JobSeekerWorkExp;
import com.jobportal.entity.Login;
import com.jobportal.entity.Payment;
import com.jobportal.entity.Recruiter;
import com.jobportal.entity.SeekerCategoryJoin;
import com.jobportal.model.JobCategoryModel;
import com.jobportal.model.JobSeekerModel;
import com.jobportal.model.RecruiterModel;
import com.jobportal.util.DateFormat;

@Service
@Repository("RecruiterService")
public class RecruiterService {
	@Autowired
	private RecruiterDao myRecruiterDao;
	
	@Autowired
	private LoginDao myLoginDao;
	@Autowired
	private PaymentDao myPaymentDao;
	
	@Autowired
	private JobDao myJobDao;
	
	@Autowired
	private ApplicationDao myAppDao;
	
	public void registerRecruiter(RecruiterModel rm){
		Recruiter r=new Recruiter();
		r.setRecruiterId(rm.getFrmRecruiterId());
		r.setRecruiterName(rm.getFrmRecruiterName());
		r.setCompanyName(rm.getFrmCompanyName());
		r.setCompanyLicense(rm.getFrmCompanyLicense());
		r.setEmail(rm.getFrmEmail());
		r.setAddress(rm.getFrmAddress());
		r.setState(rm.getFrmState());
		r.setPostalCode(Integer.parseInt(rm.getFrmPostalCode()));		
		r.setDescription(rm.getFrmDescription());
		r.setStatus("activate");
		this.myRecruiterDao.saveRecruiter(r);
	}
	
	public String GetRecruiterId(){
		return this.myRecruiterDao.getRecruiterId();
	}
	
	public void getAllRecruiters(RecruiterModel model){
		 List<Recruiter> l=this.myRecruiterDao.getAllRecuiters();
		 model.setFrmRecruiterList(l);
	}
	
	public void getAllActivateRecruiters(RecruiterModel model){
		 List<Recruiter> l=this.myRecruiterDao.getAllRecuiters();
		 List<Recruiter> list1=new ArrayList<Recruiter>();
		 
		 for(Recruiter r:l){
			 if(r.getStatus().equals("activate")){
				 list1.add(r);
			 }
		 }
		 model.setFrmRecruiterList(list1);
	}
	
	public void getRecruiterbyId(RecruiterModel model){
		String rid=model.getFrmRecruiterId();
		Recruiter r=this.myRecruiterDao.getRecruiterById(rid);
		model.setRecruiter(r);
	}
	
	public void saveOrUpdateRecruiter(RecruiterModel rm){
		
		Recruiter r=new Recruiter();
		Login lm=new Login();
		
		Recruiter obj=this.myRecruiterDao.getRecruiterById(rm.getFrmRecruiterId());
		System.out.println("Save or Update for Login :"+lm.getLoginId());
		
		r.setRecruiterId(rm.getFrmRecruiterId());
		r.setRecruiterName(rm.getFrmRecruiterName());
		r.setCompanyName(rm.getFrmCompanyName());
		r.setCompanyLicense(rm.getFrmCompanyLicense());
		r.setEmail(rm.getFrmEmail());
		r.setAddress(rm.getFrmAddress());
		r.setState(rm.getFrmState());
		r.setPostalCode(Integer.parseInt(rm.getFrmPostalCode()));		
		r.setDescription(rm.getFrmDescription());
		r.setStatus("activate");
		this.myRecruiterDao.SaveOrUpdate(r);
		
		lm=this.myLoginDao.CheckUserLogin1(obj.getEmail());
		lm.setUsername(rm.getFrmRecruiterName());
		lm.setLoginId(rm.getFrmRecruiterId());
		lm.setEmail(rm.getFrmEmail());
		this.myLoginDao.saveOrUpdateLoginInfo(lm);
		
	}
	
	public void activateRecruiterById(RecruiterModel model){
		String id=model.getFrmRecruiterId();
		System.out.println("JOB SEEKER ID IN JOB SEEKER SERVICE -->"+id);
		Recruiter r=this.myRecruiterDao.getRecruiterById(id);
		
		String status=r.getStatus();
		
		if(status.equals("deactivate")){
			r.setStatus("activate");
			this.myRecruiterDao.SaveOrUpdate(r);
			model.setRecruiter(r);
		}
		model.setRecruiter(r);
		
	}
	
	public void deactivateRecruiter(RecruiterModel model){
		String id=model.getFrmRecruiterId();
		Recruiter recruiter=this.myRecruiterDao.getRecruiterById(id);
		recruiter.setStatus("deactivate");
		this.myRecruiterDao.SaveOrUpdateRecruiter(recruiter);
	}
	
	public void deleteRecruiter(RecruiterModel model){
		
		String id=model.getFrmRecruiterId();
		Recruiter recruiter=this.myRecruiterDao.getRecruiterById(id);
	
		this.myRecruiterDao.delete(recruiter);
		
		Login user=this.myLoginDao.getOneLogin(id);
		if(user!=null)
		this.myLoginDao.deleteLogin(user);	
		List<Payment> paymentList=this.myPaymentDao.getAllPaymentByRecruiterId(id);
		if(paymentList!=null){
			for(Payment p:paymentList){
				this.myPaymentDao.deletePaymentById(p);
			}
		}

	}
}
