package com.jobportal.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jobportal.entity.JobSeeker;
import com.jobportal.entity.JobSeekerEducation;
import com.jobportal.entity.JobSeekerWorkExp;
import com.jobportal.util.JobSeekerId;

@Repository("JobSeekerEducationDao")
public class JobSeekerEducationDao extends AbstractDao<Integer, JobSeekerEducation> {
	
	public void saveEducation(JobSeekerEducation jobSeekerEducaton)
	{
		super.persistVoid(jobSeekerEducaton);
    }
	
	public void saveOrUpdateEducation(JobSeekerEducation jobSeekerEducaton)
	{
		super.SaveOrUpdate(jobSeekerEducaton);
    }
	
	public List<JobSeekerEducation> getAllEducation(){
		return super.getAllEntity();
	}
	
	public List<JobSeekerEducation> getAllEducationbyId(String jobSeekerId){
		return super.criteriaQueryGetObjectsByName(jobSeekerId, "jobSeekerId");
	}
	
	public JobSeekerEducation getEducationbyEduId(int id){
		return super.criteriaQueryGetObjectById(id, "educationId");
	}
	
	public void deleteEducationById(JobSeekerEducation edu){
		super.delete(edu);
	}
}
