package com.jobportal.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jobportal.entity.Job;
import com.jobportal.entity.JobSeeker;
import com.jobportal.entity.JobSeekerEducation;
import com.jobportal.entity.JobSeekerWorkExp;
import com.jobportal.model.JobModel;
import com.jobportal.util.JobSeekerId;

@Repository("JobDao")
public class JobDao extends AbstractDao<Integer, Job> {
	
	public void saveJob(Job job)
	{
		super.persistVoid(job);
    }
	
	public List<Job> getAllJobs(){
		return super.getAllEntity();
	}
	
	public Job getJobById(int id){
		return super.criteriaQueryGetObjectById(id, "jobId");
	}
	public List<Job> getJobByRecruiterId(String id){
		List<Job> l=super.criteriaQueryGetObjectsByName(id, "recruiterId");
		return l;
	}
	
	public void deleteJobById(Job job){
		super.delete(job);
	}
	
	public void updateJob(int id){
		Job job=new Job();
		super.update(job);
	}
	
	public void saveOrUpdateJob(Job job){
		
		super.SaveOrUpdate(job);
	}
}
