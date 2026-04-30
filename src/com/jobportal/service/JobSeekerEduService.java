package com.jobportal.service;

import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jobportal.dao.JobCategoryDao;
import com.jobportal.dao.JobSeekerDao;
import com.jobportal.dao.JobSeekerEducationDao;
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
@Repository("JobSeekerEduService")
public class JobSeekerEduService {
	
	@Autowired
	private JobSeekerEducationDao myEduDao;
	
	@Autowired
	private JobSeekerDao myJobSeekerDao;
	
	public void registerEdu(FileBucket model) throws IOException{
		JobSeekerEducation edu=new JobSeekerEducation();
		MultipartFile multipartFile = model.getFile();
		
		edu.setInstitutionAttended(model.getInstitutionAttended());
		edu.setCompletionDate(model.getCompletionDate());
		edu.setCertification(model.getCertification());
		edu.setCertificationFile(multipartFile.getBytes());
		edu.setContentType(multipartFile.getContentType());
		edu.setFileName(multipartFile.getOriginalFilename());
		String seekerId=model.getJobSeekerId();
		System.out.println("JobSeekerEdu Seeker Id--->"+seekerId);
		System.out.println("JobSeekerEdu Completion month-->"+model.getCompletionDate());
		JobSeeker js=new JobSeeker();
		js=this.myJobSeekerDao.getJobSeekerbyId(seekerId);
		edu.setJobSeeker(js);
		
		this.myEduDao.saveEducation(edu);
		
	}
	
	public void getAllEducation(FileBucket model){
		
		String seekerId=model.getJobSeekerId();

		JobSeeker js=new JobSeeker();
		js=this.myJobSeekerDao.getJobSeekerbyId(seekerId);
		Set<JobSeekerEducation> list=js.getJobSeekerEducation();
		List<JobSeekerEducation> list1=new ArrayList<JobSeekerEducation>();
		for(JobSeekerEducation edu:list){
			list1.add(edu);
		}
		model.setEduList(list1);

	}
	
	public JobSeekerEducation getEducationById(String strId){
		JobSeekerEducation edu=this.myEduDao.getEducationbyEduId(Integer.parseInt(strId));
		return edu;
	}
	
	public void prepareUpdateJobSeekerEdu(FileBucket model){
		String eduId=model.getEduId();
		String seekerId=model.getJobSeekerId();
		JobSeekerEducation edu=this.myEduDao.getEducationbyEduId(Integer.parseInt(eduId));
		model.setJobSeekerEdu(edu);
	}
	
	public void updateJobSeekerEdu(FileBucket model) throws IOException{
		MultipartFile multipartFile = model.getFile();

		String eduId=model.getEduId();
		//String seekerId=model.getJobSeekerId();
		JobSeekerEducation edu=this.myEduDao.getEducationbyEduId(Integer.parseInt(eduId));
		edu.setInstitutionAttended(model.getInstitutionAttended());
		edu.setEducationId(Integer.parseInt(eduId));
		edu.setCompletionDate(model.getCompletionDate());
		edu.setCertification(model.getCertification());
		if(multipartFile.isEmpty() || multipartFile.equals(null)){
			edu.setCertificationFile(edu.getCertificationFile());
			edu.setContentType(edu.getContentType());
			edu.setFileName(edu.getFileName());
			
		}else{
			edu.setCertificationFile(multipartFile.getBytes());
			edu.setContentType(multipartFile.getContentType());
			edu.setFileName(multipartFile.getOriginalFilename());
			
		}
		this.myEduDao.saveOrUpdateEducation(edu);

	}
	
	public void deleteJobSeekerEdu(FileBucket fileBucket){
		String eduId=fileBucket.getEduId();
		JobSeekerEducation edu=this.myEduDao.getEducationbyEduId(Integer.parseInt(eduId));
		this.myEduDao.deleteEducationById(edu);
	}
}
