package com.jobportal.model;

import java.util.List;

import com.jobportal.entity.JobCategory;

public class JobCategoryModel {
	private String frmJobTitle;
	private String id;
	private List<JobCategory> frmJobCategoryList;
	private JobCategory jobCategory;

	public String getFrmJobTitle() {
		return frmJobTitle;
	}

	public void setFrmJobTitle(String frmJobTitle) {
		this.frmJobTitle = frmJobTitle;
	}

	public List<JobCategory> getFrmJobCategoryList() {
		return frmJobCategoryList;
	}

	public void setFrmJobCategoryList(List<JobCategory> frmJobCategoryList) {
		this.frmJobCategoryList = frmJobCategoryList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public JobCategory getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(JobCategory jobCategory) {
		this.jobCategory = jobCategory;
	}

	
}
