package com.jobportal.service;

import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jobportal.dao.ApplicationDao;
import com.jobportal.dao.JobCategoryDao;
import com.jobportal.dao.JobDao;
import com.jobportal.dao.JobSeekerDao;
import com.jobportal.dao.JobSeekerEducationDao;
import com.jobportal.dao.JobSeekerWorkExpDao;
import com.jobportal.dao.RecruiterDao;
import com.jobportal.dao.SeekerCategoryJoinDao;
import com.jobportal.dao.SelectionDao;
import com.jobportal.entity.Application;
import com.jobportal.entity.Job;
import com.jobportal.entity.JobCategory;
import com.jobportal.entity.JobSeeker;
import com.jobportal.entity.JobSeekerEducation;
import com.jobportal.entity.JobSeekerWorkExp;
import com.jobportal.entity.Recruiter;
import com.jobportal.entity.SeekerCategoryJoin;
import com.jobportal.entity.SeekerCategoryJoinId;
import com.jobportal.entity.Selection;
import com.jobportal.model.ApplicationModel;
import com.jobportal.model.FileBucket;
import com.jobportal.model.JobSeekerModel;
import com.jobportal.model.JobSeekerWorkExpModel;
import com.jobportal.model.LoginModel;
import com.jobportal.model.RegisterJobSeekerForm;
import com.jobportal.util.DateFormat;

@Service
@Repository("ApplicationService")
public class ApplicationService {
	
	@Autowired
	private ApplicationDao myAppDao;
	
	@Autowired
	private JobSeekerDao myJobSeekerDao;
	
	@Autowired
	private JobDao myJobDao;
	
	@Autowired
	private SelectionDao mySelectionDao;
	
	public void registerApplication(ApplicationModel model) throws IOException{
		Application app=new Application();
		MultipartFile multipartFile = model.getFile();
		
		app.setStatus("pending");
		app.setResume(model.getResume());
		app.setDateApplied(new Date());
		app.setCvForm(multipartFile.getBytes());
		app.setFileName(multipartFile.getOriginalFilename());
		app.setContentType(multipartFile.getContentType());
		String seekerId=model.getJobSeekerId();
		app.setJobSeekerId(seekerId);

		String recruiterId=model.getRecruiterId();
		String jobId=model.getJobId();
		app.setJobId(Integer.parseInt(jobId));
		JobSeeker js=this.myJobSeekerDao.getJobSeekerbyId(seekerId);
		app.setJobSeeker(js);
		
		Job j=this.myJobDao.getJobById(Integer.parseInt(jobId));
		app.setJob(j);
		
		this.myAppDao.saveApplication(app);
	}
	
	public void getApplicationByJobId(ApplicationModel model){
		String jobId=model.getJobId();
		List<Application> l=this.myAppDao.getApplicationByJobId(Integer.parseInt(jobId));
		model.setAppList(l);
	}
	
	public void getActivateApplicationByJobId(ApplicationModel model){
		String jobId=model.getJobId();
		List<Application> l=this.myAppDao.getApplicationByJobId(Integer.parseInt(jobId));
		List<Application> list1=new ArrayList<Application>();
		if(l!=null){
			for(Application app:l){
				if(app.getJobSeeker().getStatus().equals("activate")){
					list1.add(app);
				}
			}
			model.setAppList(list1);
		}
	
	}
	
	public Application getAnApplicationById(String id){
		Application app=this.myAppDao.getAppById(Integer.parseInt(id));
		return app;
	}
	
	public void getAllApplicationBySeekerId(ApplicationModel model){
		String id=model.getJobSeekerId();
		List<Application> l=this.myAppDao.getAllApplicationBySeekerId(id);
		model.setAppList(l);
	}
	
	public void makeSelection(ApplicationModel model) throws IOException{
		String appId=model.getAppId();
		Application app=this.myAppDao.getAppById(Integer.parseInt(appId));
	
			Selection s=new Selection();
			s.setApplication(app);
			s.setSelectionId(Integer.parseInt(appId));
			s.setStatus(model.getSelectionStatus());
			this.mySelectionDao.saveSelection(s);
			
			Selection selection=this.mySelectionDao.getselectionById(Integer.parseInt(appId));
			String selectionstatus=selection.getStatus();
			
			if(selectionstatus.equals("selected")){
				app.setApplicationId(Integer.parseInt(appId));
				app.setStatus("received");
				this.myAppDao.saveOrUpdateApplication(app);
				System.out.println("saveOrUpdateApplication -->"+app.getStatus());
			}
		}

}
	


