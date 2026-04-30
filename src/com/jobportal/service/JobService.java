package com.jobportal.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jobportal.dao.ApplicationDao;
import com.jobportal.dao.JobCategoryDao;
import com.jobportal.dao.JobDao;
import com.jobportal.dao.JobSeekerDao;
import com.jobportal.dao.JobSeekerWorkExpDao;
import com.jobportal.dao.RecruiterDao;
import com.jobportal.dao.SeekerCategoryJoinDao;
import com.jobportal.entity.Application;
import com.jobportal.entity.Job;
import com.jobportal.entity.JobCategory;
import com.jobportal.entity.JobSeeker;
import com.jobportal.entity.JobSeekerEducation;
import com.jobportal.entity.JobSeekerWorkExp;
import com.jobportal.entity.Login;
import com.jobportal.entity.Recruiter;
import com.jobportal.entity.SeekerCategoryJoin;
import com.jobportal.entity.SeekerCategoryJoinId;
import com.jobportal.model.FileBucket;
import com.jobportal.model.JobModel;
import com.jobportal.model.JobSeekerModel;
import com.jobportal.model.JobSeekerWorkExpModel;
import com.jobportal.model.LoginModel;
import com.jobportal.model.RecruiterModel;
import com.jobportal.model.RegisterJobForm;
import com.jobportal.model.RegisterJobSeekerForm;
import com.jobportal.util.DateFormat;

@Service
@Repository("JobService")
public class JobService {
	
	@Autowired
	private JobDao myJobDao;
	
	@Autowired
	private ApplicationDao myAppDao;
	
	@Autowired
	private RecruiterDao myRecruiterDao;
	
	@Autowired
	private JobCategoryDao myCategoryDao;
	
	public void prepareJobRegister(RegisterJobForm model){
		  List<JobCategory> cats=this.myCategoryDao.getAllCategory();
			for( JobCategory c:cats){
				model.getMapAllCategory().put(""+c.getId(),""+c.getJobTitle());
			}
		
	System.out.println("HASH MAP JOB  SEIVICE------>"+model.getMapAllCategory().size());
	}
	
	public void registerJob(JobModel model) throws ParseException{
		String catId=model.getFrmCatId();
		System.out.println("CATEGORY ID--->"+catId);

		JobCategory cat=this.myCategoryDao.getJobCategoryById(Integer.parseInt(catId));
		System.out.println("CATEGORY NAME--->"+cat.getJobTitle());
		Job job=new Job();
		job.setJobTitle(model.getFrmJobTitle());
		job.setJobCategoryName(cat.getJobTitle());
		job.setGender(model.getFrmGender());
		job.setAge(model.getFrmAge());
		job.setCatId(cat.getId());
		job.setJobRole(model.getFrmJobRole());
		job.setSkillsRequired(model.getFrmSkillsRequired());
		job.setJobQualification(model.getFrmJobQualification());
		job.setJobExperience(Integer.parseInt(model.getFrmJobExperience()));
		job.setJobPost(Integer.parseInt(model.getFrmJobPost()));
		job.setExpectedSalary(Integer.parseInt(model.getFrmExpectedSalary()));
		job.setJobLocation(model.getFrmJobLocation());
		job.setJobPostDate(new Date());
		job.setJobOpenDate(DateFormat.convertStrDateTimeToLocalDateTime(model.getFrmJobOpenDate()));
		job.setJobCloseDate(DateFormat.stringToDateFormat_dd_mm_yyyy1(model.getFrmJobCloseDate()));
		job.setJobDescription(model.getFrmDescription());
		job.setJobCategory(cat);
		String recruiterId=model.getFrmRecruiterId();
		job.setRecruiterId(recruiterId);
		Recruiter recruiter=this.myRecruiterDao.getRecruiterById(recruiterId);
		System.out.println("Job Service Current Date-->"+job.getJobPostDate());

		job.setRecruiter(recruiter);
		this.myJobDao.saveJob(job);
		
	}
	
	public void getAllJobs(JobModel model){
		List<Job> jobList=this.myJobDao.getAllJobs();
		List<Job> list=new ArrayList<Job>();
		Date currentDate=new Date();
		for(Job job:jobList){
			if(job.getJobOpenDate().compareTo(currentDate) < 0 && job.getJobCloseDate().compareTo(currentDate)> 0){
				list.add(job);
			}
			model.setJobList(list);		
		}
	
	}
	
	public void getAllActivateJobs(JobModel model){
		List<Job> jobList=this.myJobDao.getAllJobs();
		List<Job> list=new ArrayList<Job>();
		Date currentDate=new Date();
		for(Job job:jobList){
			if(job.getJobOpenDate().compareTo(currentDate) < 0 && job.getJobCloseDate().compareTo(currentDate)> 0
					&& job.getRecruiter().getStatus().equals("activate")){
				list.add(job);
			}
			model.setJobList(list);		
		}
	
	}
	public void getAllJobsByRecruiterId(JobModel model){
		String recruiterId=model.getFrmRecruiterId();
		List<Job> job=this.myJobDao.getJobByRecruiterId(recruiterId);
		model.setJobList(job);
	}
	
	public void prepareUpdateJob(JobModel model){
		String jobId=model.getFrmJobId();
		Job job=this.myJobDao.getJobById(Integer.parseInt(jobId));
		System.out.println("Job SERVICE--->"+job.getJobOpenDate());
		model.setJob(job);
	}
	
	public void updateJob(JobModel model) throws ParseException{

		String jobId=model.getFrmJobId();
		String catId=model.getFrmCatId();
		System.out.println("CATEGORY ID--->"+catId);
		JobCategory cat=this.myCategoryDao.getJobCategoryById(Integer.parseInt(catId));
	
		System.out.println("CATEGORY NAME--->"+cat.getJobTitle());
		//String seekerId=model.getJobSeekerId();
		Job job=this.myJobDao.getJobById(Integer.parseInt(jobId));
		job.setJobCategory(cat);
		job.setCatId(cat.getId());
		job.setJobId(Integer.parseInt(jobId));
		job.setJobTitle(model.getFrmJobTitle());
		job.setJobCategoryName(cat.getJobTitle());
		job.setGender(model.getFrmGender());
		job.setAge(model.getFrmAge());
		job.setJobRole(model.getFrmJobRole());
		job.setSkillsRequired(model.getFrmSkillsRequired());
		job.setJobQualification(model.getFrmJobQualification());
		job.setJobExperience(Integer.parseInt(model.getFrmJobExperience()));
		job.setJobPost(Integer.parseInt(model.getFrmJobPost()));
		job.setExpectedSalary(Integer.parseInt(model.getFrmExpectedSalary()));
		job.setJobLocation(model.getFrmJobLocation());
		job.setJobPostDate(new Date());
		System.out.println("Job Service : "+model.getFrmJobOpenDate());
		if(model.getFrmJobOpenDate().equals(null) || model.getFrmJobOpenDate().isEmpty()){
			job.setJobOpenDate(job.getJobOpenDate());
		}else{
			job.setJobOpenDate(DateFormat.convertStrDateTimeToLocalDateTime(model.getFrmJobOpenDate()));
		}
		job.setJobCloseDate(DateFormat.stringToDateFormat_dd_mm_yyyy1(model.getFrmJobCloseDate()));
		job.setJobDescription(model.getFrmDescription());
		this.myJobDao.saveOrUpdateJob(job);
	}
	
	public void deleteJob(JobModel model){
			
		String id=model.getFrmJobId();
		Job job=this.myJobDao.getJobById(Integer.parseInt(id));
			
		this.myJobDao.deleteJobById(job);
		}
}
