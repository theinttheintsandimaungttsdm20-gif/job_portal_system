package com.jobportal.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jobportal.entity.JobSeeker;
import com.jobportal.entity.JobSeekerWorkExp;
import com.jobportal.util.JobSeekerId;

@Repository("JobSeekerWorkExpDao")
public class JobSeekerWorkExpDao extends AbstractDao<Integer, JobSeekerWorkExp> {
	
	public void saveJobSeekerWorkExp(JobSeekerWorkExp jobSeekerWorkExp)
	{
		super.persistVoid(jobSeekerWorkExp);
    }
	public void saveOrUpdateJobSeekerWorkExp(JobSeekerWorkExp jobSeekerWorkExp)
	{
		super.SaveOrUpdate(jobSeekerWorkExp);
    }
	
	public List<JobSeekerWorkExp> getAllExpById(String strId){
		return super.criteriaQueryGetObjectsByName(strId, "jobSeekerId");
	}
	public JobSeekerWorkExp getAnExp(int id){
		JobSeekerWorkExp exp=super.criteriaQueryGetObjectById(id, "expId");
		return exp;
	}
	public void deleteExpById(JobSeekerWorkExp exp){
		super.delete(exp);
	}
}
