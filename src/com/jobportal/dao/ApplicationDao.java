package com.jobportal.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jobportal.entity.Application;
import com.jobportal.entity.Job;
import com.jobportal.entity.JobSeeker;
import com.jobportal.entity.JobSeekerEducation;
import com.jobportal.entity.JobSeekerWorkExp;
import com.jobportal.util.JobSeekerId;

@Repository("ApplicationDao")
public class ApplicationDao extends AbstractDao<Integer, Application> {
	
	public void saveApplication(Application application)
	{
		super.persistVoid(application);
    }
	
	public void saveOrUpdateApplication(Application application)
	{
		super.SaveOrUpdate(application);
    }
	
	public List<Application> getApplicationByJobId(int id){
		List<Application> l=super.criteriaQueryObjectsById(id, "jobId");
		return l;
	}
	public Application getAppById(int id){
		Application app=super.criteriaQueryGetObjectById(id, "applicationId");
		return app;
	}
	public List<Application> getAllApplicationBySeekerId(String id){
		List<Application> l=super.criteriaQueryGetObjectsByName(id, "jobSeekerId");
		return l;
	}
	
	public void deleteApp(Application app){
		super.delete(app);
	}
	
	
	
}
