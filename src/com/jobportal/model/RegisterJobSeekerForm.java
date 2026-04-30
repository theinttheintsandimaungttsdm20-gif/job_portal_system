package com.jobportal.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.jobportal.entity.JobCategory;

public class RegisterJobSeekerForm {
	private JobSeekerModel jobSeekerModel;
	private LoginModel loginModel;
	private Map<String,String> mapAllCategory=new HashMap<String,String>();
	private Map<String,String> mapFavCategory=new HashMap<String,String>();
	private List<JobCategory> catList;
	public JobSeekerModel getJobSeekerModel() {
		return jobSeekerModel;
	}
	public void setJobSeekerModel(JobSeekerModel jobSeekerModel) {
		this.jobSeekerModel = jobSeekerModel;
	}
	public LoginModel getLoginModel() {
		return loginModel;
	}
	public void setLoginModel(LoginModel loginModel) {
		this.loginModel = loginModel;
	}

	public Map<String, String> getMapAllCategory() {
		return mapAllCategory;
	}
	public void setMapAllCategory(Map<String, String> mapAllCategory) {
		this.mapAllCategory = mapAllCategory;
	}
	public List<JobCategory> getCatList() {
		return catList;
	}
	public void setCatList(List<JobCategory> catList) {
		this.catList = catList;
	}
	public Map<String, String> getMapFavCategory() {
		return mapFavCategory;
	}
	public void setMapFavCategory(Map<String, String> mapFavCategory) {
		this.mapFavCategory = mapFavCategory;
	}

}
