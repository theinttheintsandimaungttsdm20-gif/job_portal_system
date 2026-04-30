package com.jobportal.model;

import java.util.List;

import com.jobportal.entity.JobSeeker;
import com.jobportal.entity.JobSeekerWorkExp;

public class JobSeekerWorkExpModel {

	private String frmExpId;
	private String frmCompanyName;
	private String frmRole;
	private String frmStartDate;
	private String frmEndDate;
	
	private String jobSeekerId;
	private List<JobSeekerWorkExp> expList;
	private JobSeekerWorkExp frmExp;

	public JobSeekerWorkExp getFrmExp() {
		return frmExp;
	}

	public void setFrmExp(JobSeekerWorkExp frmExp) {
		this.frmExp = frmExp;
	}

	public List<JobSeekerWorkExp> getExpList() {
		return expList;
	}

	public void setExpList(List<JobSeekerWorkExp> expList) {
		this.expList = expList;
	}

	public String getJobSeekerId() {
		return jobSeekerId;
	}

	public void setJobSeekerId(String jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}

	public String getFrmExpId() {
		return frmExpId;
	}

	public void setFrmExpId(String frmExpId) {
		this.frmExpId = frmExpId;
	}

	public String getFrmCompanyName() {
		return frmCompanyName;
	}

	public void setFrmCompanyName(String frmCompanyName) {
		this.frmCompanyName = frmCompanyName;
	}

	public String getFrmRole() {
		return frmRole;
	}

	public void setFrmRole(String frmRole) {
		this.frmRole = frmRole;
	}

	public String getFrmStartDate() {
		return frmStartDate;
	}

	public void setFrmStartDate(String frmStartDate) {
		this.frmStartDate = frmStartDate;
	}

	public String getFrmEndDate() {
		return frmEndDate;
	}

	public void setFrmEndDate(String frmEndDate) {
		this.frmEndDate = frmEndDate;
	}

}
