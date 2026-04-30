package com.jobportal.model;

import java.util.HashMap;
import java.util.Map;

public class RegisterJobForm {
	private JobModel jobModel;
	private Map<String,String> mapAllCategory=new HashMap<String,String>();

	public JobModel getJobModel() {
		return jobModel;
	}
	public void setJobModel(JobModel jobModel) {
		this.jobModel = jobModel;
	}
	public Map<String, String> getMapAllCategory() {
		return mapAllCategory;
	}
	public void setMapAllCategory(Map<String, String> mapAllCategory) {
		this.mapAllCategory = mapAllCategory;
	}
}
