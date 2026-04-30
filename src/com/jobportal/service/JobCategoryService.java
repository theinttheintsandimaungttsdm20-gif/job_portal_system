package com.jobportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jobportal.dao.JobCategoryDao;
import com.jobportal.dao.JobSeekerDao;
import com.jobportal.entity.JobCategory;
import com.jobportal.entity.JobSeeker;
import com.jobportal.model.JobCategoryModel;
import com.jobportal.model.JobSeekerModel;
import com.jobportal.util.DateFormat;

@Service
@Repository("JobCategoryService")
public class JobCategoryService {
	@Autowired
	private JobCategoryDao myJobCategoryDao;
	
	public void registerJobCategory(JobCategoryModel model){
		JobCategory c=new JobCategory();
		c.setJobTitle(model.getFrmJobTitle());
		
		this.myJobCategoryDao.saveJobCategory(c);
	}
	public void getAllCategory(JobCategoryModel model){
		List<JobCategory> list=this.myJobCategoryDao.getAllCategory();
		System.out.println("JOB CATEGORY SERVICE---------->"+list.size());
		model.setFrmJobCategoryList(list);	
	}
	
	public void prepareUpdateCategory(JobCategoryModel model){
		String id=model.getId();
		JobCategory obj=this.myJobCategoryDao.getJobCategoryById(Integer.parseInt(id));
		model.setJobCategory(obj);
	}
	
	public void updateCategory(JobCategoryModel model){
		String id=model.getId();
		JobCategory obj=this.myJobCategoryDao.getJobCategoryById(Integer.parseInt(id));
		obj.setId(Integer.parseInt(id));
		obj.setJobTitle(model.getFrmJobTitle());
		this.myJobCategoryDao.saveOrUpdateJobCategory(obj);
	}
	
	public void deleteCategory(JobCategoryModel model){
		String id=model.getId();
		JobCategory obj=this.myJobCategoryDao.getJobCategoryById(Integer.parseInt(id));
		this.myJobCategoryDao.deleteJobCategory(obj);
	}
}
