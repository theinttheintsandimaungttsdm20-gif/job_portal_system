package com.jobportal.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jobportal.dao.JobCategoryDao;
import com.jobportal.dao.JobSeekerDao;
import com.jobportal.dao.JobSeekerWorkExpDao;
import com.jobportal.dao.SeekerCategoryJoinDao;
import com.jobportal.entity.JobCategory;
import com.jobportal.entity.JobSeeker;
import com.jobportal.entity.JobSeekerEducation;
import com.jobportal.entity.JobSeekerWorkExp;
import com.jobportal.entity.SeekerCategoryJoin;
import com.jobportal.entity.SeekerCategoryJoinId;
import com.jobportal.model.FileBucket;
import com.jobportal.model.JobSeekerModel;
import com.jobportal.model.JobSeekerWorkExpModel;
import com.jobportal.model.LoginModel;
import com.jobportal.model.RegisterJobSeekerForm;
import com.jobportal.util.DateFormat;

@Service
@Repository("JobSeekerWorkExpService")
public class JobSeekerWorkExpService {
	
	@Autowired
	private JobSeekerWorkExpDao myJobSeekerWorkExpDao;
	@Autowired
	private JobSeekerDao myJobSeekerDao;
	
	public void registerWorkExp(JobSeekerWorkExpModel model){
		JobSeekerWorkExp exp=new JobSeekerWorkExp();
		
		exp.setCompanyName(model.getFrmCompanyName());
		exp.setRole(model.getFrmRole());
		
		exp.setStartDate(DateFormat.stringToDateFormat_dd_mm_yyyy1(model.getFrmStartDate()));
		exp.setEndDate(DateFormat.stringToDateFormat_dd_mm_yyyy1(model.getFrmEndDate()));
		String duration=DateFormat.calculateDuration(model.getFrmStartDate(), model.getFrmEndDate());
		exp.setDuration(duration);
		
		String seekerId=model.getJobSeekerId();
		exp.setJobSeekerId(seekerId);
		System.out.println("JobSeekerWorkExpService Seeker Id--->"+seekerId);
		
		JobSeeker js=new JobSeeker();
		js=this.myJobSeekerDao.getJobSeekerbyId(seekerId);
		System.out.println("JobSeekerWorkExpService Seeker Id--->"+js.getName());

		System.out.println("JobSeekerWorkExpService------>"+js.getJobSeekerId());
		exp.setJobSeeker(js);
		this.myJobSeekerWorkExpDao.saveJobSeekerWorkExp(exp);
		
	}
	
	public void getAllExp(JobSeekerWorkExpModel model){
		String seekerId=model.getJobSeekerId();

	    List<JobSeekerWorkExp> l=this.myJobSeekerWorkExpDao.getAllExpById(seekerId);
	    model.setExpList(l);
	}
	public void prepareUpdateJobSeekerExp(JobSeekerWorkExpModel model){
		String expId=model.getFrmExpId();
		JobSeekerWorkExp exp=this.myJobSeekerWorkExpDao.getAnExp(Integer.parseInt(expId));
		model.setFrmExp(exp);
	}
	public void updateWorkExp(JobSeekerWorkExpModel model){
		String expId=model.getFrmExpId();
		JobSeekerWorkExp exp=this.myJobSeekerWorkExpDao.getAnExp(Integer.parseInt(expId));
		
		exp.setCompanyName(model.getFrmCompanyName());
		exp.setRole(model.getFrmRole());
		exp.setStartDate(DateFormat.stringToDateFormat_dd_mm_yyyy1(model.getFrmStartDate()));
		exp.setEndDate(DateFormat.stringToDateFormat_dd_mm_yyyy1(model.getFrmEndDate()));
		String duration=DateFormat.calculateDuration(model.getFrmStartDate(), model.getFrmEndDate());
		exp.setDuration(duration);
		
		this.myJobSeekerWorkExpDao.saveOrUpdateJobSeekerWorkExp(exp);
		
	}
	public void deleteWorkExp(JobSeekerWorkExpModel model){
		String expId=model.getFrmExpId();
		JobSeekerWorkExp exp=this.myJobSeekerWorkExpDao.getAnExp(Integer.parseInt(expId));
		this.myJobSeekerWorkExpDao.deleteExpById(exp);
	}
	
}
