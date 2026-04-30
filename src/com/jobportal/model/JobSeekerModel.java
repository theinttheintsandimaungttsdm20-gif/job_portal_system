package com.jobportal.model;

import java.util.List;

import com.jobportal.entity.JobSeeker;

public class JobSeekerModel {
	private String frmJobSeekerId;
	private String frmName;
	private String frmEmail;
	private String frmPhone;
	private String frmSkills;
	private String frmGender;
	private String frmDob;
	private String frmAddress;
	private String frmState;
	private String frmPostalCode;
	private String[] selectJobCategory;
	private JobSeeker jobSeeker;
	private List<JobSeeker> seekerList;
	private String frmCatId;
	
	
	public JobSeekerModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String[] getSelectJobCategory() {
		return selectJobCategory;
	}
	public void setSelectJobCategory(String[] selectJobCategory) {
		this.selectJobCategory = selectJobCategory;
	}
	public String getFrmJobSeekerId() {
		return frmJobSeekerId;
	}
	public void setFrmJobSeekerId(String frmJobSeekerId) {
		this.frmJobSeekerId = frmJobSeekerId;
	}
	public String getFrmName() {
		return frmName;
	}
	public void setFrmName(String frmName) {
		this.frmName = frmName;
	}
	public String getFrmEmail() {
		return frmEmail;
	}
	public void setFrmEmail(String frmEmail) {
		this.frmEmail = frmEmail;
	}
	public String getFrmPhone() {
		return frmPhone;
	}
	public void setFrmPhone(String frmPhone) {
		this.frmPhone = frmPhone;
	}
	public String getFrmSkills() {
		return frmSkills;
	}
	public void setFrmSkills(String frmSkills) {
		this.frmSkills = frmSkills;
	}
	public String getFrmGender() {
		return frmGender;
	}
	public void setFrmGender(String frmGender) {
		this.frmGender = frmGender;
	}
	public String getFrmDob() {
		return frmDob;
	}
	public void setFrmDob(String frmDob) {
		this.frmDob = frmDob;
	}
	public String getFrmAddress() {
		return frmAddress;
	}
	public void setFrmAddress(String frmAddress) {
		this.frmAddress = frmAddress;
	}
	public String getFrmState() {
		return frmState;
	}
	public void setFrmState(String frmState) {
		this.frmState = frmState;
	}
	public String getFrmPostalCode() {
		return frmPostalCode;
	}
	public void setFrmPostalCode(String frmPostalCode) {
		this.frmPostalCode = frmPostalCode;
	}
	public List<JobSeeker> getSeekerList() {
		return seekerList;
	}
	public void setSeekerList(List<JobSeeker> seekerList) {
		this.seekerList = seekerList;
	}
	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}
	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}
	public String getFrmCatId() {
		return frmCatId;
	}
	public void setFrmCatId(String frmCatId) {
		this.frmCatId = frmCatId;
	}
}
