package com.jobportal.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jobportal.entity.JobCategory;

@Repository("JobCategoryDao")
public class JobCategoryDao extends AbstractDao<Integer, JobCategory> {
	
	public Boolean saveJobCategory(JobCategory c)
	{
	 Boolean y= super.persistMtoM(c);
	 return y;
    }
	
	public List<JobCategory> getAllCategory(){
		List<JobCategory> list=super.getAllEntity();
		System.out.println("JOB CATEGORY DAO---------->"+list.size());
		return list;
	}
	
	public JobCategory getJobCategoryById(int id){
		JobCategory jobCategory=super.criteriaQueryGetObjectById(id, "id");
		return jobCategory;
	}
	
	public void saveOrUpdateJobCategory(JobCategory jobCategory){
		super.SaveOrUpdate(jobCategory);
	}
	
	public void deleteJobCategory(JobCategory jobCategory){
		super.delete(jobCategory);
	}
	
	public List<JobCategory> getAllJobCatgoryList(int id){
		List<JobCategory> l=super.criteriaQueryObjectsById(id, "id");
		return l;
	}
}
